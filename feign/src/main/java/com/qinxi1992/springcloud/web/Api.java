package com.qinxi1992.springcloud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Api {

    @Resource
    private MyFeignClient myFeignClient;

    @GetMapping("")
    public Integer test(Integer a, Integer b) {
        return myFeignClient.add(a, b);
    }
}
