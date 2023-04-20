package com.xy.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/14 15:16
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class OrderZKController {
    public static String  INVOKE_URL = "http://zk-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPayment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk/",String.class);
    }
}
