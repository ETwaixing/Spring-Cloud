package com.waixing.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yonglang on 2017/5/18.
 */
@FeignClient("accountapi")
public interface Server {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test(@RequestParam(value = "name") String name);

}
