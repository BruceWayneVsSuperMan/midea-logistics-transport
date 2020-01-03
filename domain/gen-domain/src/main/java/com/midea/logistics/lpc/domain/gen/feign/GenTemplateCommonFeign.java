package com.midea.logistics.lpc.domain.gen.feign;

import com.midea.logistics.lpc.domain.gen.entity.GenTemplate;
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
@FeignClient(value = "logistics-transport-gen-atomic", contextId = "GenTemplateCommonFeign")
public interface GenTemplateCommonFeign {

    @GetMapping("/gen/template/page")
    PageResponse<GenTemplate> genTemplatePage(@SpringQueryMap GenTemplate entity);

    @GetMapping("/gen/template/count")
    JsonResponse<BaseDomain> genTemplateCount(@SpringQueryMap GenTemplate entity);

    @GetMapping("/gen/template/detail")
    JsonResponse<GenTemplate> genTemplateDetail(@SpringQueryMap GenTemplate entity);

    @PostMapping("/gen/template/new")
    JsonResponse<GenTemplate> genTemplateNew(@RequestBody GenTemplate entity);

    @PutMapping("/gen/template/update")
    JsonResponse<GenTemplate> genTemplateUpdate(@RequestBody GenTemplate entity);

    @PostMapping("/gen/template/save")
    JsonResponse<GenTemplate> genTemplateSave(@RequestBody GenTemplate entity);

    @DeleteMapping("/gen/template/remove")
    JsonResponse<BaseDomain> genTemplateRemove(@RequestBody BaseDomain domain);

}
