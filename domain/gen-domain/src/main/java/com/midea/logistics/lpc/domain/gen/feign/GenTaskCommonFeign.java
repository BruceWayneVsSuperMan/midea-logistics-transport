package com.midea.logistics.lpc.domain.gen.feign;

import com.midea.logistics.lpc.domain.gen.entity.GenTask;
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
@FeignClient(value = "logistics-transport-gen-atomic", contextId = "GenTaskCommonFeign")
public interface GenTaskCommonFeign {

    @GetMapping("/gen/task/page")
    PageResponse<GenTask> genTaskPage(@SpringQueryMap GenTask entity);

    @GetMapping("/gen/task/count")
    JsonResponse<BaseDomain> genTaskCount(@SpringQueryMap GenTask entity);

    @GetMapping("/gen/task/detail")
    JsonResponse<GenTask> genTaskDetail(@SpringQueryMap GenTask entity);

    @PostMapping("/gen/task/new")
    JsonResponse<GenTask> genTaskNew(@RequestBody GenTask entity);

    @PutMapping("/gen/task/update")
    JsonResponse<GenTask> genTaskUpdate(@RequestBody GenTask entity);

    @PostMapping("/gen/task/save")
    JsonResponse<GenTask> genTaskSave(@RequestBody GenTask entity);

    @DeleteMapping("/gen/task/remove")
    JsonResponse<BaseDomain> genTaskRemove(@RequestBody BaseDomain domain);

}
