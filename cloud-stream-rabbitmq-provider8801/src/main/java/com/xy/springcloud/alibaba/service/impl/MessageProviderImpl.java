package com.xy.springcloud.alibaba.service.impl;

import com.xy.springcloud.alibaba.service.IMessageProvider;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: xy
 * @Date: 2023/4/17 10:24
 * @Description: 实现类
 * @Version: v1.0
 */
@EnableBinding(Source.class)//定义消息推送的管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("**********serial:"+serial);
        return null;
    }
}
