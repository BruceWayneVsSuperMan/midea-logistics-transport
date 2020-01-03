package com.midea.logistics.lpc.atomic.gen.rest.common;

import com.midea.logistics.lpc.atomic.gen.service.common.GenTaskService;
import com.midea.logistics.lpc.domain.gen.entity.GenTask;
import com.mideaframework.core.bean.BaseDomain;
import com.mideaframework.core.exception.BusinessException;
import com.mideaframework.core.helper.BaseHelper;
import com.mideaframework.core.web.JsonResponse;
import com.mideaframework.core.web.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 * @table: gen_task (代码生成-任务) 接口,自动生成,不可自行维护
 */

@RestController
@Validated
public class GenTaskCommonRest {

    @Autowired
    private GenTaskService genTaskService;

    /**
     * @api {get} /gen/task/page 1、代码生成-任务-获取分页
     * @apiGroup GEN_TASK
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-任务-获取分页
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目ID
     * @apiParam {Long} [tempId] <code>param</code>模板ID
     * @apiParam {String} [taskName] <code>param</code>任务名称
     * @apiParam {Integer} [needCreate] <code>param</code>是否生成
     * @apiParam {Integer} [needDelete] <code>param</code>是否删除(本地模式有效)
     * @apiParam {String} [fileSubfix] <code>param</code>生产的文件后缀
     * @apiParam {String} [projectBasePath] <code>param</code>任务项目基本路径
     * @apiParam {String} [packagePath] <code>param</code>任务包路径
     * @apiParam {String} [variables] <code>param</code>任务变量
     * @apiParam {String} [taskDesc] <code>param</code>任务描述
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目ID
     * @apiSuccess {Long} [tempId] 模板ID
     * @apiSuccess {String} [taskName] 任务名称
     * @apiSuccess {Integer} [needCreate] 是否生成
     * @apiSuccess {Integer} [needDelete] 是否删除(本地模式有效)
     * @apiSuccess {String} [fileSubfix] 生产的文件后缀
     * @apiSuccess {String} [projectBasePath] 任务项目基本路径
     * @apiSuccess {String} [packagePath] 任务包路径
     * @apiSuccess {String} [variables] 任务变量
     * @apiSuccess {String} [taskDesc] 任务描述
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "rows": [
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "tempId": "tempId",
     * "taskName": "taskName",
     * "needCreate": "needCreate",
     * "needDelete": "needDelete",
     * "fileSubfix": "fileSubfix",
     * "projectBasePath": "projectBasePath",
     * "packagePath": "packagePath",
     * "variables": "variables",
     * "taskDesc": "taskDesc",
     * },
     * ...
     * ],
     * "totalCount": 1,
     * "totalPage": 1,
     * "pageNo": 1,
     * "pageSize": 10
     * }
     * }
     */
    @GetMapping("/gen/task/page")
    public PageResponse<GenTask> genTaskPage(GenTask entity) {
        PageResponse<GenTask> page = genTaskService.page(entity);
        return page;
    }

    /**
     * @api {get} /gen/task/count 2、代码生成-任务-获取数量
     * @apiGroup GEN_TASK
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-任务-获取数量
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目ID
     * @apiParam {Long} [tempId] <code>param</code>模板ID
     * @apiParam {String} [taskName] <code>param</code>任务名称
     * @apiParam {Integer} [needCreate] <code>param</code>是否生成
     * @apiParam {Integer} [needDelete] <code>param</code>是否删除(本地模式有效)
     * @apiParam {String} [fileSubfix] <code>param</code>生产的文件后缀
     * @apiParam {String} [projectBasePath] <code>param</code>任务项目基本路径
     * @apiParam {String} [packagePath] <code>param</code>任务包路径
     * @apiParam {String} [variables] <code>param</code>任务变量
     * @apiParam {String} [taskDesc] <code>param</code>任务描述
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} count 统计结果
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "count":12
     * }
     * }
     */
    @GetMapping("/gen/task/count")
    public JsonResponse<BaseDomain> genTaskCount(GenTask entity) {
        BaseDomain baseDomain = new BaseDomain();
        Integer count = genTaskService.count(entity);
        baseDomain.setCount(count);
        JsonResponse jsonResponse = JsonResponse.success(baseDomain);
        return jsonResponse;
    }

    /**
     * @api {get} /gen/task/detail 3、代码生成-任务-获取详情
     * @apiGroup GEN_TASK
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-任务-获取详情
     * @apiParam {Long} id <code>param</code>数据Id
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目ID
     * @apiSuccess {Long} [tempId] 模板ID
     * @apiSuccess {String} [taskName] 任务名称
     * @apiSuccess {Integer} [needCreate] 是否生成
     * @apiSuccess {Integer} [needDelete] 是否删除(本地模式有效)
     * @apiSuccess {String} [fileSubfix] 生产的文件后缀
     * @apiSuccess {String} [projectBasePath] 任务项目基本路径
     * @apiSuccess {String} [packagePath] 任务包路径
     * @apiSuccess {String} [variables] 任务变量
     * @apiSuccess {String} [taskDesc] 任务描述
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "id": "id",
     * "projectId": "projectId",
     * "tempId": "tempId",
     * "taskName": "taskName",
     * "needCreate": "needCreate",
     * "needDelete": "needDelete",
     * "fileSubfix": "fileSubfix",
     * "projectBasePath": "projectBasePath",
     * "packagePath": "packagePath",
     * "variables": "variables",
     * "taskDesc": "taskDesc",
     * }
     * }
     */
    @GetMapping("/gen/task/detail")
    public JsonResponse<GenTask> genTaskDetail(GenTask entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        entity = genTaskService.get(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/task/new 4、代码生成-任务-新增信息
     * @apiGroup GEN_TASK
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-任务-新增信息
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {Long} [tempId] <code>body</code>模板ID
     * @apiParam {String} [taskName] <code>body</code>任务名称
     * @apiParam {Integer} [needCreate] <code>body</code>是否生成
     * @apiParam {Integer} [needDelete] <code>body</code>是否删除(本地模式有效)
     * @apiParam {String} [fileSubfix] <code>body</code>生产的文件后缀
     * @apiParam {String} [projectBasePath] <code>body</code>任务项目基本路径
     * @apiParam {String} [packagePath] <code>body</code>任务包路径
     * @apiParam {String} [variables] <code>body</code>任务变量
     * @apiParam {String} [taskDesc] <code>body</code>任务描述
     * @apiParamExample {json} 请求样例:
     * {
     * "projectId": "projectId",
     * "tempId": "tempId",
     * "taskName": "taskName",
     * "needCreate": "needCreate",
     * "needDelete": "needDelete",
     * "fileSubfix": "fileSubfix",
     * "projectBasePath": "projectBasePath",
     * "packagePath": "packagePath",
     * "variables": "variables",
     * "taskDesc": "taskDesc",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/task/new")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenTask> genTaskNew(@Valid @RequestBody GenTask entity) {

        // 按需添加限制条件

        Long id = genTaskService.insert(entity);
        entity.setId(id);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {put} /gen/task/update 5、代码生成-任务-更新信息
     * @apiGroup GEN_TASK
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-任务-更新信息
     * @apiParam {Long} id <code>body</code>自增长主键
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {Long} [tempId] <code>body</code>模板ID
     * @apiParam {String} [taskName] <code>body</code>任务名称
     * @apiParam {Integer} [needCreate] <code>body</code>是否生成
     * @apiParam {Integer} [needDelete] <code>body</code>是否删除(本地模式有效)
     * @apiParam {String} [fileSubfix] <code>body</code>生产的文件后缀
     * @apiParam {String} [projectBasePath] <code>body</code>任务项目基本路径
     * @apiParam {String} [packagePath] <code>body</code>任务包路径
     * @apiParam {String} [variables] <code>body</code>任务变量
     * @apiParam {String} [taskDesc] <code>body</code>任务描述
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "tempId": "tempId",
     * "taskName": "taskName",
     * "needCreate": "needCreate",
     * "needDelete": "needDelete",
     * "fileSubfix": "fileSubfix",
     * "projectBasePath": "projectBasePath",
     * "packagePath": "packagePath",
     * "variables": "variables",
     * "taskDesc": "taskDesc",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PutMapping("/gen/task/update")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenTask> genTaskUpdate(@Valid @RequestBody GenTask entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        GenTask target = genTaskService.get(entity.getId());
        if (target == null) {
            throw BusinessException.fail("id is error, data is not exist");
        }
        GenTask.copyIfNotNull(entity, target);
        genTaskService.updateAll(target);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/task/save 6、代码生成-任务-保存信息
     * @apiGroup GEN_TASK
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-任务-保存信息
     * @apiParam {Long} id <code>body</code>自增长主键【存在即更新，不存在即创建】
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {Long} [tempId] <code>body</code>模板ID
     * @apiParam {String} [taskName] <code>body</code>任务名称
     * @apiParam {Integer} [needCreate] <code>body</code>是否生成
     * @apiParam {Integer} [needDelete] <code>body</code>是否删除(本地模式有效)
     * @apiParam {String} [fileSubfix] <code>body</code>生产的文件后缀
     * @apiParam {String} [projectBasePath] <code>body</code>任务项目基本路径
     * @apiParam {String} [packagePath] <code>body</code>任务包路径
     * @apiParam {String} [variables] <code>body</code>任务变量
     * @apiParam {String} [taskDesc] <code>body</code>任务描述
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "tempId": "tempId",
     * "taskName": "taskName",
     * "needCreate": "needCreate",
     * "needDelete": "needDelete",
     * "fileSubfix": "fileSubfix",
     * "projectBasePath": "projectBasePath",
     * "packagePath": "packagePath",
     * "variables": "variables",
     * "taskDesc": "taskDesc",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/task/save")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenTask> genTaskSave(@Valid @RequestBody GenTask entity) {
        genTaskService.saveSelective(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {delete} /gen/task/remove 7、代码生成-任务-删除【单个，批量】
     * @apiGroup GEN_TASK
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-任务-删除【单个，批量】
     * @apiParam {Integer} [id] <code>body</code> 主键 id
     * @apiParam {Integer[]} [ids] <code>body</code> 主键 id组
     * @apiParamExample {json} 请求样例:
     * {
     * "id": 1,
     * "ids": [1]
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": 1
     * }
     */
    @DeleteMapping("/gen/task/remove")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<BaseDomain> genTaskRemove(@Valid @RequestBody BaseDomain domain) {
        List<Long> ids = BaseHelper.getIdsFromDomain(domain);
        genTaskService.deleteBatch(ids);
        JsonResponse jsonResponse = JsonResponse.success(domain);
        return jsonResponse;
    }

}
