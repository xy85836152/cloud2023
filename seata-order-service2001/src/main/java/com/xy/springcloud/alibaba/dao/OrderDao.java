package com.xy.springcloud.alibaba.dao;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:01
 * @Description: dao
 * @Version: v1.0
 */

import com.xy.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao
{
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}

