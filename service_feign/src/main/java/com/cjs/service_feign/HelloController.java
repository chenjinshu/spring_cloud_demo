package com.cjs.service_feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private ServiceFeign serviceFeign;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return serviceFeign.sayHello(name);  // 调用这个方法时，实际上就会去请求EUREKA-CLIENT服务下的hi接口
                                             // 由于这个服务名对应了2个服务，所以由于负载均衡会交替出现不同的结果
                                             // 相对于rest+ribbon的方式，feign这种伪http接口封装的形式更为易读
    }
}
