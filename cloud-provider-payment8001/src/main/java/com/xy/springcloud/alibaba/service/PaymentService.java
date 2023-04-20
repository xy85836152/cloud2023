package com.xy.springcloud.alibaba.service;

import com.xy.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xy
 * @Date: 2023/4/13 22:14
 * @Description: 支付服务接口
 * @Version: v1.0
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
