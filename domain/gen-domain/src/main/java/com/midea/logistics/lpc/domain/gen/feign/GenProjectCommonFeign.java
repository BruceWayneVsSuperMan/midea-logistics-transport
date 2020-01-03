package com.midea.logistics.lpc.domain.gen.feign;

import com.midea.logistics.lpc.domain.gen.entity.GenProject;
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
@FeignClient(value = "logistics-transport-gen-atomic", contextId = "GenProjectCommonFeign")
public interface GenProjectCommonFeign {

    @GetMapping("/gen/project/page")
    PageResponse<GenProject> genProjectPage(@SpringQueryMap GenProject entity);

    @GetMapping("/gen/project/count")
    JsonResponse<BaseDomain> genProjectCount(@SpringQueryMap GenProject entity);

    @GetMapping("/gen/project/detail")
    JsonResponse<GenProject> genProjectDetail(@SpringQueryMap GenProject entity);

    @PostMapping("/gen/project/new")
    JsonResponse<GenProject> genProjectNew(@RequestBody GenProject entity);

    @PutMapping("/gen/project/update")
    JsonResponse<GenProject> genProjectUpdate(@RequestBody GenProject entity);

    @PostMapping("/gen/project/save")
    JsonResponse<GenProject> genProjectSave(@RequestBody GenProject entity);

    @DeleteMapping("/gen/project/remove")
    JsonResponse<BaseDomain> genProjectRemove(@RequestBody BaseDomain domain);

}
