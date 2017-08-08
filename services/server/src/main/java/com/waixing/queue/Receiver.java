package com.waixing.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 队列接收者
 *
 * Created by yonglang on 2017/8/8.
 */
@Component
public class Receiver {

    @RabbitListener(queues = "packets")
    public void processPackets(String message) {
        System.out.println("Receiver  : " + message);
    }

    @RabbitListener(queues = "games")
    public void processGames(String message) {
        System.out.println("Receiver  : " + message);
    }

}
