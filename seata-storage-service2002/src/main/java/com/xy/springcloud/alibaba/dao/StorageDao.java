package com.xy.springcloud.alibaba.dao;

/**
 * @Author: xy
 * @Date: 2023/4/19 15:07
 * @Description: dao
 * @Version: v1.0
 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {


    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

