package com.qinxi1992.springcloud.api;

import com.qinxi1992.springcloud.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by qinxi on 2016/10/26.
 */
@RestController
public class Index {

    @Autowired
    RestTemplate client;

    @RequestMapping("/add")
    public String add() {
        return client.getForEntity("http://COMPUTE-SERVICE/add?a=2&b=4", String.class).getBody();
    }


    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return computeService.addService();
    }
}
