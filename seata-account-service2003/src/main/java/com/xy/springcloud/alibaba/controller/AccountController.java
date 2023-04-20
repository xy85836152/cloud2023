package com.xy.springcloud.alibaba.controller;

import com.xy.springcloud.alibaba.domain.CommonResult1;
import com.xy.springcloud.alibaba.entities.CommonResult;
import com.xy.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: xy
 * @Date: 2023/4/19 15:26
 * @Description: 控制类
 * @Version: v1.0
 */
@RestController
@Slf4j
public class AccountController {
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(Long userId, BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }

    @RequestMapping("/account/test")
    public CommonResult test(Long productId, Integer count) {
        log.info("===test success====");
        return new CommonResult(200,"success！");
    }
}
