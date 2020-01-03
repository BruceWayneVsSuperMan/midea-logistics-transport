package com.midea.logistics.lpc.domain.gen.feign;

import com.midea.logistics.lpc.domain.gen.entity.GenLog;
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
@FeignClient(value = "logistics-transport-gen-atomic", contextId = "GenLogCommonFeign")
public interface GenLogCommonFeign {

    @GetMapping("/gen/log/page")
    PageResponse<GenLog> genLogPage(@SpringQueryMap GenLog entity);

    @GetMapping("/gen/log/count")
    JsonResponse<BaseDomain> genLogCount(@SpringQueryMap GenLog entity);

    @GetMapping("/gen/log/detail")
    JsonResponse<GenLog> genLogDetail(@SpringQueryMap GenLog entity);

    @PostMapping("/gen/log/new")
    JsonResponse<GenLog> genLogNew(@RequestBody GenLog entity);

    @PutMapping("/gen/log/update")
    JsonResponse<GenLog> genLogUpdate(@RequestBody GenLog entity);

    @PostMapping("/gen/log/save")
    JsonResponse<GenLog> genLogSave(@RequestBody GenLog entity);

    @DeleteMapping("/gen/log/remove")
    JsonResponse<BaseDomain> genLogRemove(@RequestBody BaseDomain domain);

}
