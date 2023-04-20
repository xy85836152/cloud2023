package com.xy.springcloud.alibaba.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: xy
 * @Date: 2023/4/13 21:33
 * @Description: 支付类
 * @Version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable  {
    private Long id;
    private String serial;
}
