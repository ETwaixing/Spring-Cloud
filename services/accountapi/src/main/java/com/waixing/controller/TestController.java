package com.waixing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yonglang on 2017/5/18.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(String name){
        return "test:"+name;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<String> list(String name){
        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(name);
        list.add(name);
        list.add("321321");
        return list;
    }

}
