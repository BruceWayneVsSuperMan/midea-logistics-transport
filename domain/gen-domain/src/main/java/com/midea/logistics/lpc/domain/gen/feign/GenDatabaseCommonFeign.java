package com.midea.logistics.lpc.domain.gen.feign;

import com.midea.logistics.lpc.domain.gen.entity.GenDatabase;
import com.mideaframework.core.bean.BaseDomain;
import com.mideaframework.core.web.JsonResponse;
import com.mideaframework.core.web.PageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;


/**
 * ©Copyright ©1968-2020 Midea Group,IT
 *
 * @author: DOP Group GEN
 */
@FeignClient(value = "logistics-transport-gen-atomic", contextId = "GenDatabaseCommonFeign")
public interface GenDatabaseCommonFeign {

    @GetMapping("/gen/database/page")
    PageResponse<GenDatabase> genDatabasePage(@SpringQueryMap GenDatabase entity);

    @GetMapping("/gen/database/count")
    JsonResponse<BaseDomain> genDatabaseCount(@SpringQueryMap GenDatabase entity);

    @GetMapping("/gen/database/detail")
    JsonResponse<GenDatabase> genDatabaseDetail(@SpringQueryMap GenDatabase entity);

    @PostMapping("/gen/database/new")
    JsonResponse<GenDatabase> genDatabaseNew(@RequestBody GenDatabase entity);

    @PutMapping("/gen/database/update")
    JsonResponse<GenDatabase> genDatabaseUpdate(@RequestBody GenDatabase entity);

    @PostMapping("/gen/database/save")
    JsonResponse<GenDatabase> genDatabaseSave(@RequestBody GenDatabase entity);

    @DeleteMapping("/gen/database/remove")
    JsonResponse<BaseDomain> genDatabaseRemove(@RequestBody BaseDomain domain);

}
