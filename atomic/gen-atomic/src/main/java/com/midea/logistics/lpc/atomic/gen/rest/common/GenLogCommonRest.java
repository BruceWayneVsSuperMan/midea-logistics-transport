package com.midea.logistics.lpc.atomic.gen.rest.common;

import com.midea.logistics.lpc.atomic.gen.service.common.GenLogService;
import com.midea.logistics.lpc.domain.gen.entity.GenLog;
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
 * @table: gen_log (代码生成-日志) 接口,自动生成,不可自行维护
 */

@RestController
@Validated
public class GenLogCommonRest {

    @Autowired
    private GenLogService genLogService;

    /**
     * @api {get} /gen/log/page 1、代码生成-日志-获取分页
     * @apiGroup GEN_LOG
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-日志-获取分页
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目ID
     * @apiParam {String} [authCode] <code>param</code>授权码
     * @apiParam {String} [genPath] <code>param</code>生成路径
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目ID
     * @apiSuccess {String} [authCode] 授权码
     * @apiSuccess {String} [genPath] 生成路径
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "rows": [
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
     * "genPath": "genPath",
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
    @GetMapping("/gen/log/page")
    public PageResponse<GenLog> genLogPage(GenLog entity) {
        PageResponse<GenLog> page = genLogService.page(entity);
        return page;
    }

    /**
     * @api {get} /gen/log/count 2、代码生成-日志-获取数量
     * @apiGroup GEN_LOG
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-日志-获取数量
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目ID
     * @apiParam {String} [authCode] <code>param</code>授权码
     * @apiParam {String} [genPath] <code>param</code>生成路径
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
    @GetMapping("/gen/log/count")
    public JsonResponse<BaseDomain> genLogCount(GenLog entity) {
        BaseDomain baseDomain = new BaseDomain();
        Integer count = genLogService.count(entity);
        baseDomain.setCount(count);
        JsonResponse jsonResponse = JsonResponse.success(baseDomain);
        return jsonResponse;
    }

    /**
     * @api {get} /gen/log/detail 3、代码生成-日志-获取详情
     * @apiGroup GEN_LOG
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-日志-获取详情
     * @apiParam {Long} id <code>param</code>数据Id
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目ID
     * @apiSuccess {String} [authCode] 授权码
     * @apiSuccess {String} [genPath] 生成路径
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
     * "genPath": "genPath",
     * }
     * }
     */
    @GetMapping("/gen/log/detail")
    public JsonResponse<GenLog> genLogDetail(GenLog entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        entity = genLogService.get(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/log/new 4、代码生成-日志-新增信息
     * @apiGroup GEN_LOG
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-日志-新增信息
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {String} [authCode] <code>body</code>授权码
     * @apiParam {String} [genPath] <code>body</code>生成路径
     * @apiParamExample {json} 请求样例:
     * {
     * "projectId": "projectId",
     * "authCode": "authCode",
     * "genPath": "genPath",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/log/new")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenLog> genLogNew(@Valid @RequestBody GenLog entity) {

        // 按需添加限制条件

        Long id = genLogService.insert(entity);
        entity.setId(id);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {put} /gen/log/update 5、代码生成-日志-更新信息
     * @apiGroup GEN_LOG
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-日志-更新信息
     * @apiParam {Long} id <code>body</code>自增长主键
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {String} [authCode] <code>body</code>授权码
     * @apiParam {String} [genPath] <code>body</code>生成路径
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
     * "genPath": "genPath",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PutMapping("/gen/log/update")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenLog> genLogUpdate(@Valid @RequestBody GenLog entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        GenLog target = genLogService.get(entity.getId());
        if (target == null) {
            throw BusinessException.fail("id is error, data is not exist");
        }
        GenLog.copyIfNotNull(entity, target);
        genLogService.updateAll(target);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/log/save 6、代码生成-日志-保存信息
     * @apiGroup GEN_LOG
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-日志-保存信息
     * @apiParam {Long} id <code>body</code>自增长主键【存在即更新，不存在即创建】
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {String} [authCode] <code>body</code>授权码
     * @apiParam {String} [genPath] <code>body</code>生成路径
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
     * "genPath": "genPath",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/log/save")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenLog> genLogSave(@Valid @RequestBody GenLog entity) {
        genLogService.saveSelective(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {delete} /gen/log/remove 7、代码生成-日志-删除【单个，批量】
     * @apiGroup GEN_LOG
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-日志-删除【单个，批量】
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
    @DeleteMapping("/gen/log/remove")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<BaseDomain> genLogRemove(@Valid @RequestBody BaseDomain domain) {
        List<Long> ids = BaseHelper.getIdsFromDomain(domain);
        genLogService.deleteBatch(ids);
        JsonResponse jsonResponse = JsonResponse.success(domain);
        return jsonResponse;
    }

}
