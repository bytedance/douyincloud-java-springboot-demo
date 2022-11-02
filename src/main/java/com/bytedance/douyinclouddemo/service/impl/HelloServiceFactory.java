package com.bytedance.douyinclouddemo.service.impl;

import com.bytedance.douyinclouddemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFactory {
    @Qualifier("redis")
    @Autowired
    private HelloService redisImpl;
    @Qualifier("mongo")
    @Autowired
    private HelloService mongoImpl;
    public HelloService getHelloService(String target){
        if("redis".equalsIgnoreCase(target)){
            return redisImpl;
        }else if ("mongodb".equalsIgnoreCase(target)){
            return mongoImpl;
        }
        return null;
    }
}
