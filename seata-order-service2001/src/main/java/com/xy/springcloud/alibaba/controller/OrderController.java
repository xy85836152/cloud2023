package com.xy.springcloud.alibaba.controller;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:00
 * @Description: 控制类
 * @Version: v1.0
 */

import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.service.OrderService;
import com.xy.springcloud.alibaba.domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class OrderController{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
 

