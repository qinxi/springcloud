package com.qinxi1992.springcloud.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("COMPUTE-SERVICE")
public interface MyFeignClient {

    @GetMapping("add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);


}
