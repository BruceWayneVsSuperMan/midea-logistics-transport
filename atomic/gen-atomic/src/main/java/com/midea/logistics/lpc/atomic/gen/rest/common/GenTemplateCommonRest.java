package com.midea.logistics.lpc.atomic.gen.rest.common;

import com.midea.logistics.lpc.atomic.gen.service.common.GenTemplateService;
import com.midea.logistics.lpc.domain.gen.entity.GenTemplate;
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
 * @table: gen_template (代码生成-模板) 接口,自动生成,不可自行维护
 */

@RestController
@Validated
public class GenTemplateCommonRest {

    @Autowired
    private GenTemplateService genTemplateService;

    /**
     * @api {get} /gen/template/page 1、代码生成-模板-获取分页
     * @apiGroup GEN_TEMPLATE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-模板-获取分页
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {String} [ftlName] <code>param</code>模板名称
     * @apiParam {String} [fileSubfix] <code>param</code>生成的文件后缀
     * @apiParam {String} [ftlDesc] <code>param</code>模板描述
     * @apiParam {String} [variables] <code>param</code>模板变量
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {String} [ftlName] 模板名称
     * @apiSuccess {String} [fileSubfix] 生成的文件后缀
     * @apiSuccess {String} [ftlDesc] 模板描述
     * @apiSuccess {String} [variables] 模板变量
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "rows": [
     * {
     * "id": "id",
     * "ftlName": "ftlName",
     * "fileSubfix": "fileSubfix",
     * "ftlDesc": "ftlDesc",
     * "variables": "variables",
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
    @GetMapping("/gen/template/page")
    public PageResponse<GenTemplate> genTemplatePage(GenTemplate entity) {
        PageResponse<GenTemplate> page = genTemplateService.page(entity);
        return page;
    }

    /**
     * @api {get} /gen/template/count 2、代码生成-模板-获取数量
     * @apiGroup GEN_TEMPLATE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-模板-获取数量
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {String} [ftlName] <code>param</code>模板名称
     * @apiParam {String} [fileSubfix] <code>param</code>生成的文件后缀
     * @apiParam {String} [ftlDesc] <code>param</code>模板描述
     * @apiParam {String} [variables] <code>param</code>模板变量
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
    @GetMapping("/gen/template/count")
    public JsonResponse<BaseDomain> genTemplateCount(GenTemplate entity) {
        BaseDomain baseDomain = new BaseDomain();
        Integer count = genTemplateService.count(entity);
        baseDomain.setCount(count);
        JsonResponse jsonResponse = JsonResponse.success(baseDomain);
        return jsonResponse;
    }

    /**
     * @api {get} /gen/template/detail 3、代码生成-模板-获取详情
     * @apiGroup GEN_TEMPLATE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-模板-获取详情
     * @apiParam {Long} id <code>param</code>数据Id
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {String} [ftlName] 模板名称
     * @apiSuccess {String} [fileSubfix] 生成的文件后缀
     * @apiSuccess {String} [ftlDesc] 模板描述
     * @apiSuccess {String} [variables] 模板变量
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "id": "id",
     * "ftlName": "ftlName",
     * "fileSubfix": "fileSubfix",
     * "ftlDesc": "ftlDesc",
     * "variables": "variables",
     * }
     * }
     */
    @GetMapping("/gen/template/detail")
    public JsonResponse<GenTemplate> genTemplateDetail(GenTemplate entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        entity = genTemplateService.get(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/template/new 4、代码生成-模板-新增信息
     * @apiGroup GEN_TEMPLATE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-模板-新增信息
     * @apiParam {String} [ftlName] <code>body</code>模板名称
     * @apiParam {String} [fileSubfix] <code>body</code>生成的文件后缀
     * @apiParam {String} [ftlDesc] <code>body</code>模板描述
     * @apiParam {String} [variables] <code>body</code>模板变量
     * @apiParamExample {json} 请求样例:
     * {
     * "ftlName": "ftlName",
     * "fileSubfix": "fileSubfix",
     * "ftlDesc": "ftlDesc",
     * "variables": "variables",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/template/new")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenTemplate> genTemplateNew(@Valid @RequestBody GenTemplate entity) {

        // 按需添加限制条件

        Long id = genTemplateService.insert(entity);
        entity.setId(id);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {put} /gen/template/update 5、代码生成-模板-更新信息
     * @apiGroup GEN_TEMPLATE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-模板-更新信息
     * @apiParam {Long} id <code>body</code>自增长主键
     * @apiParam {String} [ftlName] <code>body</code>模板名称
     * @apiParam {String} [fileSubfix] <code>body</code>生成的文件后缀
     * @apiParam {String} [ftlDesc] <code>body</code>模板描述
     * @apiParam {String} [variables] <code>body</code>模板变量
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "ftlName": "ftlName",
     * "fileSubfix": "fileSubfix",
     * "ftlDesc": "ftlDesc",
     * "variables": "variables",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PutMapping("/gen/template/update")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenTemplate> genTemplateUpdate(@Valid @RequestBody GenTemplate entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        GenTemplate target = genTemplateService.get(entity.getId());
        if (target == null) {
            throw BusinessException.fail("id is error, data is not exist");
        }
        GenTemplate.copyIfNotNull(entity, target);
        genTemplateService.updateAll(target);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/template/save 6、代码生成-模板-保存信息
     * @apiGroup GEN_TEMPLATE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-模板-保存信息
     * @apiParam {Long} id <code>body</code>自增长主键【存在即更新，不存在即创建】
     * @apiParam {String} [ftlName] <code>body</code>模板名称
     * @apiParam {String} [fileSubfix] <code>body</code>生成的文件后缀
     * @apiParam {String} [ftlDesc] <code>body</code>模板描述
     * @apiParam {String} [variables] <code>body</code>模板变量
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "ftlName": "ftlName",
     * "fileSubfix": "fileSubfix",
     * "ftlDesc": "ftlDesc",
     * "variables": "variables",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/template/save")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenTemplate> genTemplateSave(@Valid @RequestBody GenTemplate entity) {
        genTemplateService.saveSelective(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {delete} /gen/template/remove 7、代码生成-模板-删除【单个，批量】
     * @apiGroup GEN_TEMPLATE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-模板-删除【单个，批量】
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
    @DeleteMapping("/gen/template/remove")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<BaseDomain> genTemplateRemove(@Valid @RequestBody BaseDomain domain) {
        List<Long> ids = BaseHelper.getIdsFromDomain(domain);
        genTemplateService.deleteBatch(ids);
        JsonResponse jsonResponse = JsonResponse.success(domain);
        return jsonResponse;
    }

}
