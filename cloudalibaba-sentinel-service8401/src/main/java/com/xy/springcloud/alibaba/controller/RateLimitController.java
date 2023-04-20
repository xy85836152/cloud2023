package com.xy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xy.springcloud.alibaba.handler.myhandler.CustomerBlockHandler;
import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xy
 * @Date: 2023/4/18 15:41
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
public class RateLimitController {
    @GetMapping("/rateLimit/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResurece(){
        return new CommonResult(200,"按资源名称限流此时OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handlerException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按URL限流此时OK",new Payment(2020L,"serial002"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客户自定义此时OK",new Payment(2020L,"serial003"));
    }

}
