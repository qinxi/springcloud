package com.qinxi1992.springcloud.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qinxi on 2016/10/15.
 */
@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /*@Autowired
    private DiscoveryClient client;*/

    @Autowired
    private Registration registration;


    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
       /* ServiceInstance instance = client.getLocalServiceInstance();*/
        String id = registration.getServiceId();
        Integer r = a + b;
        logger.info("/add, host:" + id + ", result:" + r);
        return r;
    }

    @RequestMapping(value = "/fail" ,method = RequestMethod.GET)
    public Integer fail(@RequestParam Integer a, @RequestParam Integer b) {
        //ServiceInstance instance = client.getLocalServiceInstance();
        String id = registration.getServiceId();
        Integer r = a / b;
        logger.info("/add, host:" + id + ", result:" + r);
        return r;
    }
}
