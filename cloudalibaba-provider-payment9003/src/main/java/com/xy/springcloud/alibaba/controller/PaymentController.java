package com.xy.springcloud.alibaba.controller;

import cn.hutool.core.lang.UUID;
import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xy
 * @Date: 2023/4/18 16:21
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L, UUID.randomUUID().toString()));
        hashMap.put(2L,new Payment(2L, UUID.randomUUID().toString()));
        hashMap.put(3L,new Payment(3L, UUID.randomUUID().toString()));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql serverPort"+serverPort,payment);
        return result;
    }
}
