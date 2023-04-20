package com.xy.springcloud.alibaba.handler.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.entities.Payment;

/**
 * @Author: xy
 * @Date: 2023/4/18 16:00
 * @Description: 处理类
 * @Version: v1.0
 */
public class CustomerBlockHandler
{
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义，global---1",new Payment(2020L,"serial2003"));
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义，global--2",new Payment(2020L,"serial2003"));
    }
}
