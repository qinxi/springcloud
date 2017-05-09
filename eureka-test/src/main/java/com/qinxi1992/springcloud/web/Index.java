package com.qinxi1992.springcloud.web;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Created by qinxi on 2017/5/9.
 */
@RestController
public class Index {

    @Resource
    DiscoveryClient client;

    @Resource
    RestTemplate restTemplate;



    @RequestMapping("/test")
    public  String getSentence() {
        List<ServiceInstance> list = client.getInstances("compute-service");
        URI u = list.get(0).getUri();

        return restTemplate.getForObject(u.toString()+"/add?a=1&b=2", String.class);
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
}
