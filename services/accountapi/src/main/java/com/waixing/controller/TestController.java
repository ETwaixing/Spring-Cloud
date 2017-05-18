package com.waixing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yonglang on 2017/5/18.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(String name){
        return "test:"+name;
    }

}
