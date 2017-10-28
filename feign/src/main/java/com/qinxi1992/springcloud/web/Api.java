package com.qinxi1992.springcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class Api {

    @Resource
    private MyFeignClient myFeignClient;

    @GetMapping("")
    public Integer test(Integer a, Integer b) {
        log.info("feign--");
        return myFeignClient.add(a, b);
    }
}
