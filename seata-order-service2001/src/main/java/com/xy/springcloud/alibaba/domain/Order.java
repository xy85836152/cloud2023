package com.xy.springcloud.alibaba.domain;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:03
 * @Description: 订单类
 * @Version: v1.0
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status; //订单状态：0：创建中；1：已完结
}


