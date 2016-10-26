package com.qinxi1992.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by qinxi on 2016/10/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaApplication.class, args);
    }
}
