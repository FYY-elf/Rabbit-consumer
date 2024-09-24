package com.fyy.rabbitconsumer.Theam;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TheamProviderConfig {

    //声明键值
    public final static String Key1="key1";
    public final static String Key2="key2";

    //声明队列并绑定键
    @Bean
    public Queue FirstQueue(){
        return new Queue(TheamProviderConfig.Key1);
    }

    @Bean
    public Queue SecondQueue(){
        return new Queue(TheamProviderConfig.Key2);
    }

    //声明交换机
    @Bean
    public TopicExchange Exchange(){
        return new TopicExchange("topicExchange");
    }

    //交换机和队列绑定
    @Bean
    Binding binding1(){
        return BindingBuilder.bind(FirstQueue()).to(Exchange()).with(Key1);
    }

    @Bean
    Binding binding2(){
        return BindingBuilder.bind(SecondQueue()).to(Exchange()).with(Key2);
    }
}
