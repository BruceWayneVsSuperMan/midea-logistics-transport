package com.midea.logistics.lpc.atomic.gen.rest.common;

import com.midea.logistics.lpc.atomic.gen.service.common.GenDatabaseService;
import com.midea.logistics.lpc.domain.gen.entity.GenDatabase;
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
 * @table: gen_database (代码生成-数据库) 接口,自动生成,不可自行维护
 */

@RestController
@Validated
public class GenDatabaseCommonRest {

    @Autowired
    private GenDatabaseService genDatabaseService;

    /**
     * @api {get} /gen/database/page 1、代码生成-数据库-获取分页
     * @apiGroup GEN_DATABASE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-数据库-获取分页
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目id, 关联gen_project表id
     * @apiParam {String} [connectionUrl] <code>param</code>数据库链接
     * @apiParam {String} [driverClass] <code>param</code>数据库驱动地址
     * @apiParam {String} [databaseName] <code>param</code>数据库名称
     * @apiParam {String} [username] <code>param</code>数据库用户名
     * @apiParam {String} [password] <code>param</code>数据库密码
     * @apiParam {String} [prefix] <code>param</code>表前缀
     * @apiParam {String} [effectiveTables] <code>param</code>生效的表,英文逗号分隔
     * @apiParam {String} [ignoreCloumns] <code>param</code>忽略的字段,英文逗号分隔
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目id, 关联gen_project表id
     * @apiSuccess {String} [connectionUrl] 数据库链接
     * @apiSuccess {String} [driverClass] 数据库驱动地址
     * @apiSuccess {String} [databaseName] 数据库名称
     * @apiSuccess {String} [username] 数据库用户名
     * @apiSuccess {String} [password] 数据库密码
     * @apiSuccess {String} [prefix] 表前缀
     * @apiSuccess {String} [effectiveTables] 生效的表,英文逗号分隔
     * @apiSuccess {String} [ignoreCloumns] 忽略的字段,英文逗号分隔
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "rows": [
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "connectionUrl": "connectionUrl",
     * "driverClass": "driverClass",
     * "databaseName": "databaseName",
     * "username": "username",
     * "password": "password",
     * "prefix": "prefix",
     * "effectiveTables": "effectiveTables",
     * "ignoreCloumns": "ignoreCloumns",
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
    @GetMapping("/gen/database/page")
    public PageResponse<GenDatabase> genDatabasePage(GenDatabase entity) {
        PageResponse<GenDatabase> page = genDatabaseService.page(entity);
        return page;
    }

    /**
     * @api {get} /gen/database/count 2、代码生成-数据库-获取数量
     * @apiGroup GEN_DATABASE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-数据库-获取数量
     * @apiParam {Long} [id] <code>param</code>自增长主键
     * @apiParam {Long} [projectId] <code>param</code>项目id, 关联gen_project表id
     * @apiParam {String} [connectionUrl] <code>param</code>数据库链接
     * @apiParam {String} [driverClass] <code>param</code>数据库驱动地址
     * @apiParam {String} [databaseName] <code>param</code>数据库名称
     * @apiParam {String} [username] <code>param</code>数据库用户名
     * @apiParam {String} [password] <code>param</code>数据库密码
     * @apiParam {String} [prefix] <code>param</code>表前缀
     * @apiParam {String} [effectiveTables] <code>param</code>生效的表,英文逗号分隔
     * @apiParam {String} [ignoreCloumns] <code>param</code>忽略的字段,英文逗号分隔
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
    @GetMapping("/gen/database/count")
    public JsonResponse<BaseDomain> genDatabaseCount(GenDatabase entity) {
        BaseDomain baseDomain = new BaseDomain();
        Integer count = genDatabaseService.count(entity);
        baseDomain.setCount(count);
        JsonResponse jsonResponse = JsonResponse.success(baseDomain);
        return jsonResponse;
    }

    /**
     * @api {get} /gen/database/detail 3、代码生成-数据库-获取详情
     * @apiGroup GEN_DATABASE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-数据库-获取详情
     * @apiParam {Long} id <code>param</code>数据Id
     * @apiParamExample {param} 请求样例:
     * ?id=1
     * @apiSuccess {Long} [id] 自增长主键
     * @apiSuccess {Long} [projectId] 项目id, 关联gen_project表id
     * @apiSuccess {String} [connectionUrl] 数据库链接
     * @apiSuccess {String} [driverClass] 数据库驱动地址
     * @apiSuccess {String} [databaseName] 数据库名称
     * @apiSuccess {String} [username] 数据库用户名
     * @apiSuccess {String} [password] 数据库密码
     * @apiSuccess {String} [prefix] 表前缀
     * @apiSuccess {String} [effectiveTables] 生效的表,英文逗号分隔
     * @apiSuccess {String} [ignoreCloumns] 忽略的字段,英文逗号分隔
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": {
     * "id": "id",
     * "projectId": "projectId",
     * "connectionUrl": "connectionUrl",
     * "driverClass": "driverClass",
     * "databaseName": "databaseName",
     * "username": "username",
     * "password": "password",
     * "prefix": "prefix",
     * "effectiveTables": "effectiveTables",
     * "ignoreCloumns": "ignoreCloumns",
     * }
     * }
     */
    @GetMapping("/gen/database/detail")
    public JsonResponse<GenDatabase> genDatabaseDetail(GenDatabase entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        entity = genDatabaseService.get(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/database/new 4、代码生成-数据库-新增信息
     * @apiGroup GEN_DATABASE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-数据库-新增信息
     * @apiParam {Long} [projectId] <code>body</code>项目id, 关联gen_project表id
     * @apiParam {String} [connectionUrl] <code>body</code>数据库链接
     * @apiParam {String} [driverClass] <code>body</code>数据库驱动地址
     * @apiParam {String} [databaseName] <code>body</code>数据库名称
     * @apiParam {String} [username] <code>body</code>数据库用户名
     * @apiParam {String} [password] <code>body</code>数据库密码
     * @apiParam {String} [prefix] <code>body</code>表前缀
     * @apiParam {String} [effectiveTables] <code>body</code>生效的表,英文逗号分隔
     * @apiParam {String} [ignoreCloumns] <code>body</code>忽略的字段,英文逗号分隔
     * @apiParamExample {json} 请求样例:
     * {
     * "projectId": "projectId",
     * "connectionUrl": "connectionUrl",
     * "driverClass": "driverClass",
     * "databaseName": "databaseName",
     * "username": "username",
     * "password": "password",
     * "prefix": "prefix",
     * "effectiveTables": "effectiveTables",
     * "ignoreCloumns": "ignoreCloumns",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/database/new")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenDatabase> genDatabaseNew(@Valid @RequestBody GenDatabase entity) {

        // 按需添加限制条件

        Long id = genDatabaseService.insert(entity);
        entity.setId(id);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {put} /gen/database/update 5、代码生成-数据库-更新信息
     * @apiGroup GEN_DATABASE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-数据库-更新信息
     * @apiParam {Long} id <code>body</code>自增长主键
     * @apiParam {Long} [projectId] <code>body</code>项目id, 关联gen_project表id
     * @apiParam {String} [connectionUrl] <code>body</code>数据库链接
     * @apiParam {String} [driverClass] <code>body</code>数据库驱动地址
     * @apiParam {String} [databaseName] <code>body</code>数据库名称
     * @apiParam {String} [username] <code>body</code>数据库用户名
     * @apiParam {String} [password] <code>body</code>数据库密码
     * @apiParam {String} [prefix] <code>body</code>表前缀
     * @apiParam {String} [effectiveTables] <code>body</code>生效的表,英文逗号分隔
     * @apiParam {String} [ignoreCloumns] <code>body</code>忽略的字段,英文逗号分隔
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "connectionUrl": "connectionUrl",
     * "driverClass": "driverClass",
     * "databaseName": "databaseName",
     * "username": "username",
     * "password": "password",
     * "prefix": "prefix",
     * "effectiveTables": "effectiveTables",
     * "ignoreCloumns": "ignoreCloumns",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PutMapping("/gen/database/update")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenDatabase> genDatabaseUpdate(@Valid @RequestBody GenDatabase entity) {
        if (entity.getId() == null) {
            throw BusinessException.fail("id can not be null");
        }
        GenDatabase target = genDatabaseService.get(entity.getId());
        if (target == null) {
            throw BusinessException.fail("id is error, data is not exist");
        }
        GenDatabase.copyIfNotNull(entity, target);
        genDatabaseService.updateAll(target);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {post} /gen/database/save 6、代码生成-数据库-保存信息
     * @apiGroup GEN_DATABASE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-数据库-保存信息
     * @apiParam {Long} id <code>body</code>自增长主键【存在即更新，不存在即创建】
     * @apiParam {Long} [projectId] <code>body</code>项目id, 关联gen_project表id
     * @apiParam {String} [connectionUrl] <code>body</code>数据库链接
     * @apiParam {String} [driverClass] <code>body</code>数据库驱动地址
     * @apiParam {String} [databaseName] <code>body</code>数据库名称
     * @apiParam {String} [username] <code>body</code>数据库用户名
     * @apiParam {String} [password] <code>body</code>数据库密码
     * @apiParam {String} [prefix] <code>body</code>表前缀
     * @apiParam {String} [effectiveTables] <code>body</code>生效的表,英文逗号分隔
     * @apiParam {String} [ignoreCloumns] <code>body</code>忽略的字段,英文逗号分隔
     * @apiParamExample {json} 请求样例:
     * {
     * "id": "id",
     * "projectId": "projectId",
     * "connectionUrl": "connectionUrl",
     * "driverClass": "driverClass",
     * "databaseName": "databaseName",
     * "username": "username",
     * "password": "password",
     * "prefix": "prefix",
     * "effectiveTables": "effectiveTables",
     * "ignoreCloumns": "ignoreCloumns",
     * }
     * @apiSuccessExample {json} 返回样例:
     * {
     * "code": 1,
     * "data": ObjectModel
     * }
     */
    @PostMapping("/gen/database/save")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<GenDatabase> genDatabaseSave(@Valid @RequestBody GenDatabase entity) {
        genDatabaseService.saveSelective(entity);
        JsonResponse jsonResponse = JsonResponse.success(entity);
        return jsonResponse;
    }

    /**
     * @api {delete} /gen/database/remove 7、代码生成-数据库-删除【单个，批量】
     * @apiGroup GEN_DATABASE
     * @apiVersion 0.0.1
     * @apiDescription 代码生成-数据库-删除【单个，批量】
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
    @DeleteMapping("/gen/database/remove")
    @Transactional(rollbackFor = Exception.class)
    public JsonResponse<BaseDomain> genDatabaseRemove(@Valid @RequestBody BaseDomain domain) {
        List<Long> ids = BaseHelper.getIdsFromDomain(domain);
        genDatabaseService.deleteBatch(ids);
        JsonResponse jsonResponse = JsonResponse.success(domain);
        return jsonResponse;
    }

}
