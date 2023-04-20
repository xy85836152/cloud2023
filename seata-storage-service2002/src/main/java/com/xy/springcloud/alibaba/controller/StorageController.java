package com.xy.springcloud.alibaba.controller;

import com.xy.springcloud.alibaba.domain.CommonResult3;
import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/19 15:12
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class StorageController {
    @Resource
    private StorageService storageService;


    //扣减库存
    @RequestMapping("/storage/decrease")

    public CommonResult decrease(Long productId, Integer count) {
        log.info("productId:"+productId+"=====count:"+count);
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }

    @RequestMapping("/storage/test")
    public CommonResult test(Long productId, Integer count) {
        log.info("===test success====");
        return new CommonResult(200,"success！");
    }
}
