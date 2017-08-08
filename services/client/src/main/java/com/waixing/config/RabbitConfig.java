package com.waixing.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yonglang on 2017/8/8.
 */
@Configuration
public class RabbitConfig {
    /**
     * 设置游戏消息记录（局内）队列
     */
    @Bean(name = "packets")
    public Queue queuePackets() {
        return new Queue("packets");
    }

    /**
     * 设置游戏记录（局）队列
     */
    @Bean(name = "games")
    public Queue queueGames() {
        return new Queue("games");
    }

    /**
     * 设置游戏消息记录交换机
     */
    @Bean(name = "packetDirectExchange")
    public DirectExchange packetDirectExchange() {
        return new DirectExchange("packetDirectExchange");
    }

    /**
     * 设置游戏记录（局）交换机
     */
    @Bean(name = "gameDirectExchange")
    public DirectExchange gameDirectExchange() {
        return new DirectExchange("gameDirectExchange");
    }

    /**
     * 绑定游戏消息记录与交换机------routingKey:packets
     */
    @Bean
    Binding bindingPacketsToPacketDirectExchange(@Qualifier("packets") Queue queue, @Qualifier("packetDirectExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("packets");
    }

    /**
     * 绑定游戏记录（局）与交换机-----routingKey:games
     */
    @Bean
    Binding bindingGamesToGameDirectExchange(@Qualifier("games") Queue queue, @Qualifier("gameDirectExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("games");
    }

}
