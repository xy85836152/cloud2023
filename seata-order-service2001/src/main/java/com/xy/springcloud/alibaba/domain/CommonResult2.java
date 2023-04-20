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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult2<T>
{
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult2(Integer code, String message)
    {
        this(code,message,null);
    }
}

