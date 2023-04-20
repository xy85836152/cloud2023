package com.xy.springcloud.alibaba.service;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:07
 * @Description: 库存服务类
 * @Version: v1.0
 */

import com.xy.springcloud.alibaba.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "seata-storage-service")
public interface StorageService{
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
