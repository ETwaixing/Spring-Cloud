package com.waixing.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.waixing.service.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonglang on 2017/5/18.
 */
@RestController
public class TestController {
    private static final Gson gson = new Gson();
    @Autowired
    private Server s;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return s.test("123");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<String> list(){
        List<String> list = s.list("waixing");
        String s = gson.toJson(list);
        System.out.println(s);
        ArrayList<String> arrayList = gson.fromJson(s,new TypeToken<List<String>>(){}.getType());
        arrayList.forEach(System.out::println);
        return arrayList;
    }

}
