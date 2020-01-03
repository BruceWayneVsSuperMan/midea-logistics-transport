package com.midea.logistics.lpc.atomic.gen.rest;

import com.mideaframework.core.annotation.Desc;

public interface Routers {

    /**
     * 测试
     */
    @Desc("接口统一统一在这里，分组进行")
    String DEMO_TEST = "/test/temp";


    /**
     * 项目生成
     */
    @Desc("创建项目")
    String GEN_PROJECT = "/gen/project";
    @Desc("生成代码")
    String GEN_AUTH_CODE = "/gen/{authCode}";
    @Desc("获取代码规则")
    String GEN_RULE_AUTH_CODE = "/gen/rule/{authCode}";


    /**
     * 接口组1
     */
    @Desc("接口1")
    String GROUP_1_DEMO1 = "/group/1/demo1";
    @Desc("接口2")
    String GROUP_1_DEMO2 = "/group/1/demo2";


    /**
     * 接口组2
     */
    @Desc("接口1")
    String GROUP_2_DEMO1 = "/group/2/demo1";
    @Desc("接口2")
    String GROUP_2_DEMO2 = "/group/2/demo2";


}
