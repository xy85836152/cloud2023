package com.xy.springcloud.alibaba.service.impl;

import com.xy.springcloud.alibaba.dao.PaymentDao;
import com.xy.springcloud.alibaba.entities.Payment;
import com.xy.springcloud.alibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/13 22:15
 * @Description: 支付服务实现类
 * @Version: v1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
