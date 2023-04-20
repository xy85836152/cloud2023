package com.xy.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: xy
 * @Date: 2023/4/19 15:23
 * @Description: 服务类
 * @Version: v1.0
 */
public interface AccountService {
    /**
     * 扣减账户余额
     */
    void decrease(Long userId,BigDecimal money);
}
