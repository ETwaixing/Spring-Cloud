package com.waixing.controller;

import com.waixing.queue.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * Created by yonglang on 2017/8/8.
 */
@RestController
@RequestMapping(value = "/")
public class TestController {
    @Autowired
    private Sender sender;

    /**
     * 发送信息到packets队列
     */
    @RequestMapping(value = "test")
    public String sendPackets(){
        sender.sendPackets();
        return "send success!!!";
    }

    /**
     * 发送信息到game队列
     */
    @RequestMapping(value = "test1")
    public String sendGame(){
        sender.sendGame();
        return "send success!!!";
    }



}
