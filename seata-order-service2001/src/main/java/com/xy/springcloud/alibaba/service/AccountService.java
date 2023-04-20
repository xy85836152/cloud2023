package com.xy.springcloud.alibaba.service;

/**
 * @Author: xy
 * @Date: 2023/4/19 7:06
 * @Description: 账户服务类
 * @Version: v1.0
 */
import com.xy.springcloud.alibaba.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService{
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
 
