package com.xy.springcloud.alibaba.service;

import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author: xy
 * @Date: 2023/4/18 19:50
 * @Description: fallback类
 * @Version: v1.0
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回",new Payment(id,"error serial"));
    }
}
