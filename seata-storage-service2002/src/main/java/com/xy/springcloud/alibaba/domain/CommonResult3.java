package com.xy.springcloud.alibaba.domain;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:00
 * @Description: 返回结果类
 * @Version: v1.0
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult3<T> implements Serializable
{
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult3(Integer code, String message)
    {
        this(code,message,null);
    }
}

