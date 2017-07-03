package com.waixing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yonglang on 2017/7/3.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(String name){
        return "test"+name;
    }


}
