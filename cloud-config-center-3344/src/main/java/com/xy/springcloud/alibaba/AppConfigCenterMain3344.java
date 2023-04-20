package com.xy.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: xy
 * @Date: 2023/4/16 16:37
 * @Description: 启动类
 * @Version: v1.0
 */
@SpringBootApplication
@EnableConfigServer
public class AppConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigCenterMain3344.class,args);
    }
}
