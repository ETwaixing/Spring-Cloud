package com.waixing.controller;

import com.waixing.service.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yonglang on 2017/5/18.
 */
@RestController
public class TestController {

    @Autowired
    Server s;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return s.test("123");
    }

}
