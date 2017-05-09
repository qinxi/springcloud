package com.qinxi1992.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * Created by qinxi on 2017/5/9.
 */
@Service
public class TestService implements ITestService {
    @Override
    public String hello(String name) {
        return "你好"+name;
    }
}
