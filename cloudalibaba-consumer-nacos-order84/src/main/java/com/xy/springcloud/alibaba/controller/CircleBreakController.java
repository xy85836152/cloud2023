package com.xy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @RequestMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Integer id){

        CommonResult<Payment> result =  restTemplate.getForObject(serverURL+"/paymentSQL/"+id,CommonResult.class,id);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        }else if(result.getData()==null){
            throw new NullPointerException("NullPointerException，空指针异常");

        }
        return result;
    }
}
