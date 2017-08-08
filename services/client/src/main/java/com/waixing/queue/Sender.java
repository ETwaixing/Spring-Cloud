package com.waixing.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  队列 发送者
 *
 * Created by yonglang on 2017/8/8.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendPackets() {
        String context = "packets队列 游戏消息记录--" + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("packetDirectExchange","packets", context);
    }

    public void sendGame() {
        String context = "games队列 游戏记录（局）--" + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("gameDirectExchange","games", context);
    }

}
