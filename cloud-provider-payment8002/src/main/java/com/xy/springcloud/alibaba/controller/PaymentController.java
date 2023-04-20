package com.xy.springcloud.alibaba.controller;

import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.entities.Payment;
import com.xy.springcloud.alibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/13 22:23
 * @Description: 支付控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort ;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入成功,serverPort="+serverPort,result);
        }else{
            return new CommonResult(999,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*********插入结果："+result);
        if(result!=null){
            return new CommonResult(200,"查询成功,serverPort="+serverPort,result);
        }else{
            return new CommonResult(999,"查询失败：id="+id,null);
        }
    }

    @GetMapping(value = "/payment/lb/{id}")
    public String lb(@PathVariable("id") Long id){
        return serverPort;
    }
}
