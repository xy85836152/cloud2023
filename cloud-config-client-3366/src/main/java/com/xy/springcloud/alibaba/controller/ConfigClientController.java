package com.xy.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xy
 * @Date: 2023/4/17 8:15
 * @Description: 启动类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "configInfo:"+configInfo+"\t serverPort:"+serverPort;
    }
}
