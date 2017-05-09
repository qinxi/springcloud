package com.qinxi1992.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by qinxi on 2016/10/26.
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String failService() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/fail?a=10&b=0", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }
}
