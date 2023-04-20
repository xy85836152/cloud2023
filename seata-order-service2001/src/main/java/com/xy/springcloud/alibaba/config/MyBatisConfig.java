package com.xy.springcloud.alibaba.config;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:09
 * @Description: mybatis配置类
 * @Version: v1.0
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.xy.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
