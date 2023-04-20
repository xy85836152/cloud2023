package com.xy.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;



/**
 * @Author: xy
 * @Date: 2023/4/19 15:13
 * @Description: 配置类
 * @Version: v1.0
 */
@Configuration
@MapperScan({"com.xy.springcloud.alibaba.dao"})
public class MybatisConfig {

}
