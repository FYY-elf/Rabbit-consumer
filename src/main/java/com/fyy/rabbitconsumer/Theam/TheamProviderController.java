package com.fyy.rabbitconsumer.Theam;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheamProviderController {

    @Autowired
    RabbitTemplate rabbitTemplate;//提供了发送/接收消息的方法

    @GetMapping("/sendTheamMessage")
    public void sendTheamMessage() {
        String msg ="主题交换机消息";
        rabbitTemplate.convertAndSend("topicExchange","key1",msg);
        rabbitTemplate.convertAndSend("topicExchange","key2",msg);
    }

}
