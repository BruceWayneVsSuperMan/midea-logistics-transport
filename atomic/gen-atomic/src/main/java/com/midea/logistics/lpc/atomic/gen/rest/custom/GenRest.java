package com.midea.logistics.lpc.atomic.gen.rest.custom;

import com.midea.logistics.lpc.atomic.gen.helper.LzGenHelper;
import com.midea.logistics.lpc.atomic.gen.pojo.ProjectInfo;
import com.midea.logistics.lpc.atomic.gen.pojo.Table;
import com.midea.logistics.lpc.atomic.gen.rest.Routers;
import com.midea.logistics.lpc.atomic.gen.service.common.*;
import com.midea.logistics.lpc.atomic.gen.util.DbUtill;
import com.midea.logistics.lpc.atomic.gen.util.PathUtil;
import com.midea.logistics.lpc.domain.gen.dto.GenProjectDto;
import com.midea.logistics.lpc.domain.gen.entity.*;
import com.mideaframework.core.bean.GenTaskInfo;
import com.mideaframework.core.utils.CompressUtil;
import com.mideaframework.core.web.JsonResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class GenRest {

    private static final Logger logger = LoggerFactory.getLogger(GenRest.class);

    @Autowired
    private GenDatabaseService genDatabaseService;
    @Autowired
    private GenProjectService genProjectService;
    @Autowired
    private GenAuthService genAuthService;
    @Autowired
    private GenLogService genLogService;
    @Autowired
    private GenTaskService genTaskService;
    @Autowired
    private LzGenHelper lzGenHelper;


    @GetMapping("/test/db")
    public JsonResponse testDb() {
        GenDatabase genDatabase = genDatabaseService.get(1L);
        List<Table> tables = DbUtill.getTables(genDatabase);
        tables.forEach(table -> DbUtill.getColums(genDatabase, table));
        return JsonResponse.success(tables);
    }

    @PostMapping(Routers.GEN_PROJECT)
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse genProject(HttpServletRequest req, @Valid @RequestBody ProjectInfo projectInfo) {
        // 标准项目id, 一切表字段的填充都以该项目为模板
        final Long STANDARD_PROJECT_ID = 1L;
        // 随机生成的授权码长度
        final Integer AUTH_CODE_LENGTH = 32;

        // project
        GenProject genProject = genProjectService.get(STANDARD_PROJECT_ID);
        genProject.setProjectDomain(projectInfo.getProjectDomain());
        genProject.setProjectName(projectInfo.getProjectName());
        genProject.setProjectDesc(projectInfo.getProjectName());
        genProjectService.insert(genProject);
        Long newProjectId = genProject.getId();

        // database
        GenDatabase genDatabase = genDatabaseService.get(new GenDatabase().setProjectId(STANDARD_PROJECT_ID));
        genDatabase.setConnectionUrl(projectInfo.getConnectionUrl());
        genDatabase.setDatabaseName(projectInfo.getDatabaseName());
        genDatabase.setUsername(projectInfo.getUsername());
        genDatabase.setPassword(projectInfo.getPassword());
        genDatabase.setPrefix(projectInfo.getPrefix());
        genDatabase.setProjectId(newProjectId);
        genDatabaseService.insert(genDatabase);

        // auth
        GenAuth genAuth = genAuthService.get(new GenAuth().setProjectId(STANDARD_PROJECT_ID));
        genAuth.setAuthCode(RandomStringUtils.randomAlphanumeric(AUTH_CODE_LENGTH));
        genAuth.setProjectId(newProjectId);
        genAuthService.insert(genAuth);

        // task
        GenTask genTask = new GenTask().setProjectId(STANDARD_PROJECT_ID);
        genTask.setOrderBy("id");
        List<GenTask> tasks = genTaskService.list(genTask);
        List<GenTask> genTasks = tasks.stream().map(t -> {
            t.setProjectId(newProjectId);
            t.setProjectBasePath(
                t.getProjectBasePath().replaceFirst(
                    "/\\w*-",
                    "/" + projectInfo.getSubModule() + "-")
            );
            t.setPackagePath(
                t.getPackagePath().replaceFirst(
                    "(^\\w*\\.)\\w*(\\.)",
                    "$1" + projectInfo.getSubModule() + "$2")
            );
            // 该task特殊, 需要设置变量
            if (t.getTaskName().equals("feign")) {
                t.setVariables("{\"serviceId\": \"" + projectInfo.getFeignServiceId() + "\"}");
            }
            return t;
        }).collect(Collectors.toList());
        genTaskService.insertBatch(genTasks);

        return JsonResponse.success(genAuth);
    }


    @GetMapping(Routers.GEN_AUTH_CODE)
    public JsonResponse gen(HttpServletRequest req, HttpServletResponse rep, @PathVariable("authCode") String authCode) {
        if (StringUtils.isBlank(authCode)) {
            return JsonResponse.fail("authCode can not be null");
        }

        GenAuth genAuth = new GenAuth();
        genAuth.setAuthCode(authCode);
        genAuth = genAuthService.get(genAuth);
        if (genAuth == null) {
            return JsonResponse.fail("authCode is not exist");
        }

        Long projectId = genAuth.getProjectId();
        if (projectId == null) {
            return JsonResponse.fail("projectId is not ");
        }

        GenProject genProject = genProjectService.get(projectId);
        GenProjectDto projectDto = new GenProjectDto();
        GenProjectDto.copy(genProject, projectDto);
        String distPath = PathUtil.getDistPath();
        projectDto.setDistPath(distPath);


        // 日志
        GenLog genLog = new GenLog();
        genLog.setProjectId(projectId);
        genLog.setAuthCode(authCode);
        genLog.setGenPath(distPath);
        genLog.setCreateUserCode("dop");
        genLog.setCreateTime(new Date());
        genLog.setUpdateUserCode("dop");
        genLog.setUpdateTime(new Date());
        genLog.setVersion(0);
        genLog.setDeleteFlag(0);
        Long logId = genLogService.insert(genLog);

        Long databaseId = genDatabaseService.get(genProject.getId()).getId();
        GenDatabase genDatabase = genDatabaseService.get(databaseId);

        // 生成
        lzGenHelper.gen(projectDto, genDatabase);

        genLog = genLogService.get(logId);
        genLog.setEndTime(new Date());
        genLogService.updateSelective(genLog);

        // 压缩
        String tarZipFilePath = distPath + ".zip";

        try {
            FileOutputStream fos = new FileOutputStream(new File(distPath + ".zip"));
            CompressUtil.zip(distPath, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        OutputStream fops = null;
        InputStream in = null;
        int len = 0;
        byte[] bytes = new byte[1024];
        try {
            File file = new File(tarZipFilePath);
            String fileName = file.getName();
            logger.info("the zip file is in {}", file.getPath());

            in = new FileInputStream(file);

            rep.setContentType("application/octet-stream");
            rep.setCharacterEncoding("UTF-8");
            rep.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            rep.setHeader("Content-Length", String.valueOf(file.length()));

            fops = rep.getOutputStream();
            while ((len = in.read(bytes)) != -1) {
                fops.write(bytes, 0, len);
            }
            fops.flush();
            fops.close();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (fops != null) {
                try {
                    fops.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return null;
    }


    @GetMapping(Routers.GEN_RULE_AUTH_CODE)
    public JsonResponse genRule(@PathVariable("authCode") String authCode) {
        if (StringUtils.isBlank(authCode)) {
            return JsonResponse.fail("authCode can not be null");
        }

        GenAuth genAuth = new GenAuth();
        genAuth.setAuthCode(authCode);
        genAuth = genAuthService.get(genAuth);
        if (genAuth == null) {
            return JsonResponse.fail("authCode is not exist");
        }

        Long projectId = genAuth.getProjectId();
        if (projectId == null) {
            return JsonResponse.fail("projectId is not ");
        }

        // 项目信息
        GenProject genProject = genProjectService.get(projectId);

        // 配置
        GenTask genTask = new GenTask();
        genTask.setProjectId(projectId);
        genTask.setOrderBy("id");
        List<GenTask> list = genTaskService.list(genTask);
        List<GenTaskInfo> taskInfos = list.stream().map(l -> {
            GenTaskInfo task = new GenTaskInfo();
            task.setProjectDomain(genProject.getProjectDomain());
            task.setTempId(l.getTempId());
            task.setTaskName(l.getTaskName());
            task.setNeedCreate(l.getNeedCreate());
            task.setNeedDelete(l.getNeedDelete());
            task.setFileSubfix(l.getFileSubfix());
            task.setProjectBasePath(l.getProjectBasePath());
            task.setPackagePath(l.getPackagePath());
            task.setTaskDesc(l.getTaskDesc());
            return task;
        }).collect(Collectors.toList());
        return JsonResponse.success(taskInfos);
    }

}
