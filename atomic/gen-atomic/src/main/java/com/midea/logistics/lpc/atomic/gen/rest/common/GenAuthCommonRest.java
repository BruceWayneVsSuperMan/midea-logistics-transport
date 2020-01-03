package com.midea.logistics.lpc.atomic.gen.rest.common;

import com.midea.logistics.lpc.atomic.gen.service.common.GenAuthService;
import com.midea.logistics.lpc.domain.gen.entity.GenAuth;
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
 * @table: gen_auth (代码生成-授权) 接口,自动生成,不可自行维护
 */

@RestController
@Validated
public class GenAuthCommonRest {

    @Autowired
    private GenAuthService genAuthService;

    /**
     * @api {get} /gen/auth/page 1、代码生成-授权-获取分页
     * @apiGroup GEN_AUTH
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-授权-获取分页
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目ID
     * @apiParam {String} [authCode] <code>param</code>授权码
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目ID
     * @apiSuccess {String} [authCode] 授权码
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "rows": [
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
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
    @GetMapping("/gen/auth/page")
    public PageResponse<GenAuth> genAuthPage(GenAuth entity) {
        PageResponse<GenAuth> page = genAuthService.page(entity);
        return page;
    }

    /**
     * @api {get} /gen/auth/count 2、代码生成-授权-获取数量
     * @apiGroup GEN_AUTH
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-授权-获取数量
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目ID
     * @apiParam {String} [authCode] <code>param</code>授权码
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
    @GetMapping("/gen/auth/count")
    public JsonResponse<BaseDomain> genAuthCount(GenAuth entity) {
        BaseDomain baseDomain = new BaseDomain();
        Integer count = genAuthService.count(entity);
        baseDomain.setCount(count);
        JsonResponse jsonResponse = JsonResponse.success(baseDomain);
        return jsonResponse;
    }

    /**
     * @api {get} /gen/auth/detail 3、代码生成-授权-获取详情
     * @apiGroup GEN_AUTH
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-授权-获取详情
     * @apiParam {Long} id <code>param</code>数据Id
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目ID
     * @apiSuccess {String} [authCode] 授权码
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
     * }
     * }
     */
    @GetMapping("/gen/auth/detail")
    public JsonResponse<GenAuth> genAuthDetail(GenAuth entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        entity = genAuthService.get(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/auth/new 4、代码生成-授权-新增信息
     * @apiGroup GEN_AUTH
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-授权-新增信息
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {String} [authCode] <code>body</code>授权码
     * @apiParamExample {json} 请求样例:
     * {
     * "projectId": "projectId",
     * "authCode": "authCode",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/auth/new")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenAuth> genAuthNew(@Valid @RequestBody GenAuth entity) {

        // 按需添加限制条件

        Long id = genAuthService.insert(entity);
        entity.setId(id);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {put} /gen/auth/update 5、代码生成-授权-更新信息
     * @apiGroup GEN_AUTH
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-授权-更新信息
     * @apiParam {Long} id <code>body</code>自增长主键
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {String} [authCode] <code>body</code>授权码
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PutMapping("/gen/auth/update")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenAuth> genAuthUpdate(@Valid @RequestBody GenAuth entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        GenAuth target = genAuthService.get(entity.getId());
        if (target == null) {
            throw BusinessException.fail("id is error, data is not exist");
        }
        GenAuth.copyIfNotNull(entity, target);
        genAuthService.updateAll(target);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/auth/save 6、代码生成-授权-保存信息
     * @apiGroup GEN_AUTH
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-授权-保存信息
     * @apiParam {Long} id <code>body</code>自增长主键【存在即更新，不存在即创建】
     * @apiParam {Long} [projectId] <code>body</code>项目ID
     * @apiParam {String} [authCode] <code>body</code>授权码
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "authCode": "authCode",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/auth/save")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenAuth> genAuthSave(@Valid @RequestBody GenAuth entity) {
        genAuthService.saveSelective(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {delete} /gen/auth/remove 7、代码生成-授权-删除【单个，批量】
     * @apiGroup GEN_AUTH
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-授权-删除【单个，批量】
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
    @DeleteMapping("/gen/auth/remove")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<BaseDomain> genAuthRemove(@Valid @RequestBody BaseDomain domain) {
        List<Long> ids = BaseHelper.getIdsFromDomain(domain);
        genAuthService.deleteBatch(ids);
        JsonResponse jsonResponse = JsonResponse.success(domain);
        return jsonResponse;
    }

}
