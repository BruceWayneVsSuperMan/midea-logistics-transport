package com.midea.logistics.lpc.atomic.gen.rest.common;

import com.midea.logistics.lpc.atomic.gen.service.common.GenProjectService;
import com.midea.logistics.lpc.domain.gen.entity.GenProject;
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
 * @table: gen_project (代码生成-项目) 接口,自动生成,不可自行维护
 */

@RestController
@Validated
public class GenProjectCommonRest {

    @Autowired
    private GenProjectService genProjectService;

    /**
     * @api {get} /gen/project/page 1、代码生成-项目-获取分页
     * @apiGroup GEN_PROJECT
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-项目-获取分页
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {String} [commonLib] <code>param</code>基础包路径
     * @apiParam {String} [projectDomain] <code>param</code>项目域
     * @apiParam {String} [projectName] <code>param</code>项目名称
     * @apiParam {String} [projectDesc] <code>param</code>项目说明
     * @apiParam {String} [dbDriverPath] <code>param</code>数据库驱动路径(服务器情况使用)
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {String} [commonLib] 基础包路径
     * @apiSuccess {String} [projectDomain] 项目域
     * @apiSuccess {String} [projectName] 项目名称
     * @apiSuccess {String} [projectDesc] 项目说明
     * @apiSuccess {String} [dbDriverPath] 数据库驱动路径(服务器情况使用)
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "rows": [
     * {
     * "id": "id",
     * "commonLib": "commonLib",
     * "projectDomain": "projectDomain",
     * "projectName": "projectName",
     * "projectDesc": "projectDesc",
     * "dbDriverPath": "dbDriverPath",
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
    @GetMapping("/gen/project/page")
    public PageResponse<GenProject> genProjectPage(GenProject entity) {
        PageResponse<GenProject> page = genProjectService.page(entity);
        return page;
    }

    /**
     * @api {get} /gen/project/count 2、代码生成-项目-获取数量
     * @apiGroup GEN_PROJECT
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-项目-获取数量
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {String} [commonLib] <code>param</code>基础包路径
     * @apiParam {String} [projectDomain] <code>param</code>项目域
     * @apiParam {String} [projectName] <code>param</code>项目名称
     * @apiParam {String} [projectDesc] <code>param</code>项目说明
     * @apiParam {String} [dbDriverPath] <code>param</code>数据库驱动路径(服务器情况使用)
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
    @GetMapping("/gen/project/count")
    public JsonResponse<BaseDomain> genProjectCount(GenProject entity) {
        BaseDomain baseDomain = new BaseDomain();
        Integer count = genProjectService.count(entity);
        baseDomain.setCount(count);
        JsonResponse jsonResponse = JsonResponse.success(baseDomain);
        return jsonResponse;
    }

    /**
     * @api {get} /gen/project/detail 3、代码生成-项目-获取详情
     * @apiGroup GEN_PROJECT
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-项目-获取详情
     * @apiParam {Long} id <code>param</code>数据Id
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {String} [commonLib] 基础包路径
     * @apiSuccess {String} [projectDomain] 项目域
     * @apiSuccess {String} [projectName] 项目名称
     * @apiSuccess {String} [projectDesc] 项目说明
     * @apiSuccess {String} [dbDriverPath] 数据库驱动路径(服务器情况使用)
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "id": "id",
     * "commonLib": "commonLib",
     * "projectDomain": "projectDomain",
     * "projectName": "projectName",
     * "projectDesc": "projectDesc",
     * "dbDriverPath": "dbDriverPath",
     * }
     * }
     */
    @GetMapping("/gen/project/detail")
    public JsonResponse<GenProject> genProjectDetail(GenProject entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        entity = genProjectService.get(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/project/new 4、代码生成-项目-新增信息
     * @apiGroup GEN_PROJECT
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-项目-新增信息
     * @apiParam {String} [commonLib] <code>body</code>基础包路径
     * @apiParam {String} [projectDomain] <code>body</code>项目域
     * @apiParam {String} [projectName] <code>body</code>项目名称
     * @apiParam {String} [projectDesc] <code>body</code>项目说明
     * @apiParam {String} [dbDriverPath] <code>body</code>数据库驱动路径(服务器情况使用)
     * @apiParamExample {json} 请求样例:
     * {
     * "commonLib": "commonLib",
     * "projectDomain": "projectDomain",
     * "projectName": "projectName",
     * "projectDesc": "projectDesc",
     * "dbDriverPath": "dbDriverPath",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/project/new")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenProject> genProjectNew(@Valid @RequestBody GenProject entity) {

        // 按需添加限制条件

        Long id = genProjectService.insert(entity);
        entity.setId(id);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {put} /gen/project/update 5、代码生成-项目-更新信息
     * @apiGroup GEN_PROJECT
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-项目-更新信息
     * @apiParam {Long} id <code>body</code>自增长主键
     * @apiParam {String} [commonLib] <code>body</code>基础包路径
     * @apiParam {String} [projectDomain] <code>body</code>项目域
     * @apiParam {String} [projectName] <code>body</code>项目名称
     * @apiParam {String} [projectDesc] <code>body</code>项目说明
     * @apiParam {String} [dbDriverPath] <code>body</code>数据库驱动路径(服务器情况使用)
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "commonLib": "commonLib",
     * "projectDomain": "projectDomain",
     * "projectName": "projectName",
     * "projectDesc": "projectDesc",
     * "dbDriverPath": "dbDriverPath",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PutMapping("/gen/project/update")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenProject> genProjectUpdate(@Valid @RequestBody GenProject entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        GenProject target = genProjectService.get(entity.getId());
        if (target == null) {
            throw BusinessException.fail("id is error, data is not exist");
        }
        GenProject.copyIfNotNull(entity, target);
        genProjectService.updateAll(target);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/project/save 6、代码生成-项目-保存信息
     * @apiGroup GEN_PROJECT
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-项目-保存信息
     * @apiParam {Long} id <code>body</code>自增长主键【存在即更新，不存在即创建】
     * @apiParam {String} [commonLib] <code>body</code>基础包路径
     * @apiParam {String} [projectDomain] <code>body</code>项目域
     * @apiParam {String} [projectName] <code>body</code>项目名称
     * @apiParam {String} [projectDesc] <code>body</code>项目说明
     * @apiParam {String} [dbDriverPath] <code>body</code>数据库驱动路径(服务器情况使用)
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "commonLib": "commonLib",
     * "projectDomain": "projectDomain",
     * "projectName": "projectName",
     * "projectDesc": "projectDesc",
     * "dbDriverPath": "dbDriverPath",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/project/save")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenProject> genProjectSave(@Valid @RequestBody GenProject entity) {
        genProjectService.saveSelective(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {delete} /gen/project/remove 7、代码生成-项目-删除【单个，批量】
     * @apiGroup GEN_PROJECT
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-项目-删除【单个，批量】
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
    @DeleteMapping("/gen/project/remove")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<BaseDomain> genProjectRemove(@Valid @RequestBody BaseDomain domain) {
        List<Long> ids = BaseHelper.getIdsFromDomain(domain);
        genProjectService.deleteBatch(ids);
        JsonResponse jsonResponse = JsonResponse.success(domain);
        return jsonResponse;
    }

}
