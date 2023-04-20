package com.xy.springcloud.alibaba.controller;

import com.xy.springcloud.alibaba.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/15 17:24
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class OrderHystrixController2 {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/consumer/payment/hystrix/err/{id}")
    public String paymentInfo_Err(@PathVariable("id") Integer id){
        String result =  paymentHystrixService.paymentInfo_Timeout(id);
        log.info("*********result="+result);
        return result;
    }


}
