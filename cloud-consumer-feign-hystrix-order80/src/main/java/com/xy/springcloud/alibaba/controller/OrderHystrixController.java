package com.xy.springcloud.alibaba.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "payment_Global_FollbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result =  paymentHystrixService.paymentInfo_OK(id);
        log.info("*********result="+result);
        return result;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod ="paymentInfo_TimeoutHandler" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
   @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result =  paymentHystrixService.paymentInfo_Timeout(id);
        log.info("*********result="+result);
        return result;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"我是消费者80，对方支付系统繁忙，请稍后再试,id:"+id+"\t/(ㄒoㄒ)/~~";
    }
    public String payment_Global_FollbackMethod(){
        return "线程池:"+Thread.currentThread().getName()+"系统繁忙，请稍后再试";
    }

}
