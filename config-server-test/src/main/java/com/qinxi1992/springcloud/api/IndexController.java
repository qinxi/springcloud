package com.qinxi1992.springcloud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qinxi on 2016/10/15.
 */
@RestController
@RequestMapping
@RefreshScope
public class IndexController {

    @Value("${from}")
    private String from;

    @RequestMapping
    public String index(){

        return from;
    }
}
