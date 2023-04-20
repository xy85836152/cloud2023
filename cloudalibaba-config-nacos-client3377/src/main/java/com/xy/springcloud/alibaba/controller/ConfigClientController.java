package com.xy.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xy
 * @Date: 2023/4/18 8:18
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
@RefreshScope //配置自动更新
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @RequestMapping(value = "/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
