package com.xy.springcloud.alibaba.controller;

import javafx.scene.control.Skin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * @Author: xy
 * @Date: 2023/4/17 11:20
 * @Description: 控制类
 * @Version: v1.0
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListListenerController {
    @Value("${server.port}")
    private String serverPort;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者，接收到的消息："+message.getPayload()+"\t serverPort:"+serverPort);
    }
}
