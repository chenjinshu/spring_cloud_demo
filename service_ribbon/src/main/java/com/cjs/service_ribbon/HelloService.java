package com.cjs.service_ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "someError")   // 对该方法开启断路功能，当此方法有异常（对应的服务不可用时），会返回指定的fallback方法的内容
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + name, String.class);
        // rest + ribbon实现负载均衡
        // 注意这里的服务名EUREKA-CLIENT不能包含下划线_    否则会报错
    }

    public String someError(String name) {
        return "hi~" + name + ", sorry, some error happened!";
    }
}
