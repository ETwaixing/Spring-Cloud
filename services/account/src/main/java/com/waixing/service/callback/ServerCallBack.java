package com.waixing.service.callback;

import com.waixing.service.Server;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yonglang on 2017/6/20.
 */
@Component
public class ServerCallBack implements Server{
    @Override
    public String test(@RequestParam(value = "name") String name) {
        return "外星外星";
    }
}
