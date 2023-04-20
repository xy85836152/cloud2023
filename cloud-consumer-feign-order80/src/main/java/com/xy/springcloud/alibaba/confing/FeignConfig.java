package com.xy.springcloud.alibaba.confing;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xy
 * @Date: 2023/4/15 14:14
 * @Description: 配置类
 * @Version: v1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
