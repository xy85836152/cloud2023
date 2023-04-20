package com.xy.springcloud.alibaba.service;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:01
 * @Description: 服务类
 * @Version: v1.0
 */
import com.xy.springcloud.alibaba.domain.Order;


public interface OrderService{
    void create(Order order);
}
