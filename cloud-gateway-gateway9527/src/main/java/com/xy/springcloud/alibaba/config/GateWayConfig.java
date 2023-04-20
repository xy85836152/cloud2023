package com.xy.springcloud.alibaba.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xy
 * @Date: 2023/4/16 11:58
 * @Description: 配置类
 * @Version: v1.0
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuilder){
        RouteLocatorBuilder.Builder routes = routeBuilder.routes();
        routes.route("path_route_xy",
                r->r.path("/finance").uri("https://new.qq.com/ch/finance/")).build();
        return routes.build();
    }
}
