package com.waixing.service;

import com.waixing.service.callback.ServerCallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by yonglang on 2017/5/18.
 */
@FeignClient(value = "accountapi")
@Component
public interface Server {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    List<String> list(@RequestParam(value = "name")String name);

}
