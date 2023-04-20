package com.xy.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/18 17:23
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    /*@RequestMapping(value = "/consumer/paymentSQL/{id}")
    public String getPayment(@PathVariable("id") Integer id){

        return restTemplate.getForObject(serverURL+"/paymentSQL/"+id,String.class);
    }*/
}
