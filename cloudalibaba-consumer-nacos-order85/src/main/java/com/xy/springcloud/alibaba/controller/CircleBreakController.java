package com.xy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.entities.Payment;
import com.xy.springcloud.alibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/18 16:42
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class CircleBreakController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    //@RequestMapping(value = "/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    @RequestMapping(value = "/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback"
            //,exceptionsToIgnore = IllegalArgumentException.class
    )
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){

        CommonResult<Payment> result =  restTemplate.getForObject(serverURL+"/paymentSQL/"+id,CommonResult.class,id);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        }else if(result.getData()==null){
            throw new NullPointerException("NullPointerException，空指针异常");

        }
        return result;
    }
    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id,Throwable e){
        Payment payment = new Payment(id,null);
        return new CommonResult<>(444,"兜底异常"+e.getMessage(),payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException e){
        Payment payment = new Payment(id,null);
        return new CommonResult<>(445,"blockHandler限流"+e.getMessage(),payment);
    }

    //====================== openfeign
    @Resource
    private PaymentService paymentService;
    @GetMapping(value="/consumer/openFeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id )
    {
        return paymentService.paymentSQL(id);
    }

}
