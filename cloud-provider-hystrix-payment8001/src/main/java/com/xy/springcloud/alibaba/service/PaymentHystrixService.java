package com.xy.springcloud.alibaba.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xy
 * @Date: 2023/4/15 15:02
 * @Description: 接口
 * @Version: v1.0
 */
@Service
public class PaymentHystrixService {
    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t哈哈哈哈";

    }
    @HystrixCommand(fallbackMethod ="paymentInfo_TimeoutHandler" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int age = 10/0;
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_Timeout,id:"+id+"\t哈哈哈";

    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"8001系统繁忙或运行出错，请稍后再试,id:"+id+"\t/(ㄒoㄒ)/~~";
    }
    //服务熔断
    @HystrixCommand(fallbackMethod ="paymentCircuitBreaker_fallback" ,commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期 毫秒
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到 多少后跳闸（10次有60%失败）
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
           throw new RuntimeException("id不能为复数");
        }
        String serialNumber = IdUtil.randomUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为复数，请稍后再试,id:"+id;
    }
}
