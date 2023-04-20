package com.xy.springcloud.alibaba.service;

/**
 * @Author: xy
 * @Date: 2023/4/19 15:09
 * @Description: 接口类
 * @Version: v1.0
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);

}
