package com.midea.logistics.lpc.atomic.gen.helper;

import com.alibaba.fastjson.JSONObject;
import com.midea.logistics.lpc.atomic.gen.pojo.Column;
import com.midea.logistics.lpc.atomic.gen.pojo.Table;
import com.midea.logistics.lpc.atomic.gen.service.common.GenTaskService;
import com.midea.logistics.lpc.atomic.gen.service.common.GenTemplateService;
import com.midea.logistics.lpc.atomic.gen.util.DbUtill;
import com.midea.logistics.lpc.atomic.gen.util.FreeMarkerTemplateUtil;
import com.midea.logistics.lpc.domain.gen.dto.GenProjectDto;
import com.midea.logistics.lpc.domain.gen.dto.GenTaskDto;
import com.midea.logistics.lpc.domain.gen.entity.GenDatabase;
import com.midea.logistics.lpc.domain.gen.entity.GenTask;
import com.midea.logistics.lpc.domain.gen.entity.GenTemplate;
import com.mideaframework.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LzGenHelper {

    private static final Logger logger = LoggerFactory.getLogger(LzGenHelper.class);

    @Autowired
    private GenTaskService genTaskService;
    @Autowired
    private GenTemplateService genTemplateService;


    private static List<String> DATETIME_COLUMNS = Arrays.asList(new String[]{"TIME", "DATE", "DATETIME", "TIMESTAMP", "YEAR"});
    private static List<String> BIGDECIMAL_COLUMNS = Arrays.asList(new String[]{"DECIMAL", "NUMERIC"});
    private static List<String> BIG_COLUMNS = Arrays.asList(new String[]{
        "LONGTEXT",
        "MEDIUMTEXT",
        "TEXT",
        "BINARY",
        "BLOB",
        "GEOMETRY",
        "LONGBLOB",
        "MEDIUMBLOB",
        "TINYBLOB",
        "VARBINARY"
    });


    public void gen(GenProjectDto project, GenDatabase database) {


        // 数据准备
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("project", project);


        GenTask genTask = new GenTask();
        genTask.setProjectId(project.getId());
        List<GenTask> genTasks = genTaskService.list(genTask);

        // 参数初始化
        List<GenTaskDto> tasks = genTasks.stream().map(task -> {
            // 路径处理
            GenTaskDto taskDto = new GenTaskDto();
            GenTaskDto.copyIfNotNull(task, taskDto);
            String packagePath = project.getProjectDomain() + "." + task.getPackagePath();
            taskDto.setPackagePath(packagePath);
            taskDto.setPackagePathWithSlantLine("/" + packagePath.replaceAll("\\.", "/"));
            return taskDto;
        }).collect(Collectors.toList());
        tasks.forEach(task -> dataMap.put(task.getTaskName(), task));

        // 过滤不需要生成的
        tasks = tasks.stream().filter(task -> {
            if ("baseModel".equals(task.getTaskName())) {
                return false;
            }
            if ("baseXml".equals(task.getTaskName())) {
                return false;
            }
            if ("baseDao".equals(task.getTaskName())) {
                return false;
            }
            if (task.getNeedCreate() == null || task.getNeedCreate() == 0) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());

        List<Table> tables = DbUtill.getTables(database);
        tables.forEach(table -> DbUtill.getColums(database, table));

        for (GenTaskDto task : tasks) {
            logger.info("======> 即将生成 {}", task.getTaskName());

            Long tempId = task.getTempId();
            GenTemplate genTemplate = genTemplateService.get(tempId);

            if (genTemplate == null) {
                throw BusinessException.fail("找不到模板");
            }

            dataMap.put("ftlVar", JSONObject.parseObject(genTemplate.getVariables()));
            dataMap.put("taskVar", JSONObject.parseObject(task.getVariables()));


            // 是否需要删除
            // boolean isDelete = (task.getNeedDelete()==null || task.getNeedDelete() == 1)? true:false ;

            // dirExistCheck
            boolean dirExistCheck = false;
            for (Table table : tables) {

                dataMap.remove("DATETIME");
                // dataMap.remove("JSON_FORMAT");
                // dataMap.remove("DATETIME_FORMAT");
                dataMap.remove("BIGDECIMAL");
                dataMap.remove("BIG_COLUMNS");

                // 数据准备【只影响  java, 不影响其他生成】
                for (Column column : table.getColumnsWithBlob()) {
                    // 是否存在时间类型
                    if (DATETIME_COLUMNS.contains(column.getMysqlType())) {
                        dataMap.put("DATETIME", "import java.util.Date;");
                        /*  已经使用配置文件解决，不再需要此项
                        dataMap.put("JSON_FORMAT","import com.fasterxml.jackson.annotation.JsonFormat;");
                        dataMap.put("DATETIME_FORMAT","import org.springframework.format.annotation.DateTimeFormat;");
                        */
                    }

                    // 是否存在大数字类型
                    if (BIGDECIMAL_COLUMNS.contains(column.getMysqlType())) {
                        dataMap.put("BIGDECIMAL", "import java.math.BigDecimal;");
                    }

                    // 是否存在无限长的字段类型
                    if (BIG_COLUMNS.contains(column.getMysqlType())) {
                        dataMap.put("BIG_COLUMNS", "BIG_COLUMNS");
                    }
                }

                dataMap.put("table", table);
                File tarFile = new File(project.getDistPath() + "/" + task.getProjectBasePath() + task.getPackagePathWithSlantLine() + "/" + table.getNameUpperCaseCamel() + genTemplate.getFileSubfix());

                PrintStream ps = null;
                try {

                    // 文件生成
                    /* 在线版本不需要这一段，必需不存在，并且需要重新生成。只有下载到客户后才需要解压和确认是否覆盖
                    if (!tarFile.isDirectory()){
                        tarFile.mkdirs();
                    }
                    // 已经存在，并且不删除，跳过。
                    if (tarFile.exists() &&  !isDelete){
                        System.out.println("文件存在无需重复===>"+tarFile.getAbsolutePath());
                        continue;
                    }
                    // 如果存在，需要删除【不删除的情况不会走到这里】
                    if (tarFile.exists()){
                        System.out.println("生成前删除旧文件===>"+tarFile.getAbsolutePath());
                        tarFile.delete();
                    }
                    */

                    // 其他情况，继续
                    if (!dirExistCheck) {
                        String absolutePath = tarFile.getAbsolutePath().replaceAll("\\\\", "/");
                        String dir = absolutePath.substring(0, absolutePath.lastIndexOf("/"));
                        File dirFile = new File(dir);
                        if (!dirFile.exists()) {
                            dirFile.mkdirs();
                            dirExistCheck = true;
                        }
                    }
                    if (!tarFile.exists()) {
                        tarFile.createNewFile();
                    }

                    String fileDataStr = FreeMarkerTemplateUtil.parseString(genTemplate.getTempContent(), dataMap);

                    ps = new PrintStream(new FileOutputStream(tarFile));

                    // 往文件里写入字符串
                    ps.println(fileDataStr);
                    // 在已有的基础上添加字符串
                    // ps.append(fileDataStr);

                    logger.info("成功生成文件======> {}", tarFile.getAbsolutePath());

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (ps != null) {
                        ps.close();
                    }
                }
            }

        }

    }


}
