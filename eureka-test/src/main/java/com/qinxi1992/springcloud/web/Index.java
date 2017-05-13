package com.qinxi1992.springcloud.web;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Map;

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
        String u = ((EurekaDiscoveryClient.EurekaServiceInstance)list.get(0)).getInstanceInfo().getVIPAddress();
        String host = list.get(0).getHost();
        Map<String,String> map = list.get(0).getMetadata();

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
