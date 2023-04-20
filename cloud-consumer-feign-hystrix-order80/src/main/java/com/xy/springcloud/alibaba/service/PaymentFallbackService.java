package com.xy.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * @Author: xy
 * @Date: 2023/4/16 7:43
 * @Description: 降级服务类
 * @Version: v1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------------PaymentFallbackService fall back paymentInfo_OK----";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "------------PaymentFallbackService fall back paymentInfo_Timeout----";
    }
}
