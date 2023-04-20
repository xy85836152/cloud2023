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
 * @Date: 2023/4/15 15:10
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result =  paymentHystrixService.paymentInfo_OK(id);
        log.info("*********result="+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result =  paymentHystrixService.paymentInfo_Timeout(id);
        log.info("*********result="+result);
        return result;
    }

    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreak(@PathVariable("id") Integer id){
        String result =  paymentHystrixService.paymentCircuitBreaker(id);
        log.info("*********result="+result);
        return result;
    }
}
