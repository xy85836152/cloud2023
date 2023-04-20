package com.xy.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: xy
 * @Date: 2023/4/17 19:38
 * @Description: 启动类
 * @Version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProviderMain9001.class,args);
    }

}
