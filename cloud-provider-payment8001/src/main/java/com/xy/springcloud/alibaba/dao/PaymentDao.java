package com.xy.springcloud.alibaba.dao;

import com.xy.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xy
 * @Date: 2023/4/13 21:59
 * @Description: 支付Dao
 * @Version: v1.0
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
