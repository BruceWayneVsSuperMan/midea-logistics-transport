package com.midea.logistics.lpc.domain.gen.feign;

import com.midea.logistics.lpc.domain.gen.entity.GenAuth;
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
@FeignClient(value = "logistics-transport-gen-atomic", contextId = "GenAuthCommonFeign")
public interface GenAuthCommonFeign {

    @GetMapping("/gen/auth/page")
    PageResponse<GenAuth> genAuthPage(@SpringQueryMap GenAuth entity);

    @GetMapping("/gen/auth/count")
    JsonResponse<BaseDomain> genAuthCount(@SpringQueryMap GenAuth entity);

    @GetMapping("/gen/auth/detail")
    JsonResponse<GenAuth> genAuthDetail(@SpringQueryMap GenAuth entity);

    @PostMapping("/gen/auth/new")
    JsonResponse<GenAuth> genAuthNew(@RequestBody GenAuth entity);

    @PutMapping("/gen/auth/update")
    JsonResponse<GenAuth> genAuthUpdate(@RequestBody GenAuth entity);

    @PostMapping("/gen/auth/save")
    JsonResponse<GenAuth> genAuthSave(@RequestBody GenAuth entity);

    @DeleteMapping("/gen/auth/remove")
    JsonResponse<BaseDomain> genAuthRemove(@RequestBody BaseDomain domain);

}
