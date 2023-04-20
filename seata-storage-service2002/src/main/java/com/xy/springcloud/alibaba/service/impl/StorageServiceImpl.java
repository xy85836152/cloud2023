package com.xy.springcloud.alibaba.service.impl;

import com.xy.springcloud.alibaba.dao.StorageDao;
import com.xy.springcloud.alibaba.service.StorageService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: xy
 * @Date: 2023/4/19 15:10
 * @Description: 实现类
 * @Version: v1.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {

        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");

    }
}
