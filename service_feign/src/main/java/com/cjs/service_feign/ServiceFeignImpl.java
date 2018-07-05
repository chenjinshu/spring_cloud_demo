package com.cjs.service_feign;

import org.springframework.stereotype.Component;

@Component
public class ServiceFeignImpl implements ServiceFeign {

    @Override
    public String sayHello(String name) {
        return "hello~" + name + ", sorry, some error happened!";
    }
}
