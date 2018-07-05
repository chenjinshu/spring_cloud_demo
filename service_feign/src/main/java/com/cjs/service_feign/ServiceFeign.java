package com.cjs.service_feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component     // 这里还需要添加这个注解，否则controller里注入ServiceFeign时会报多个type的bean的异常。
@FeignClient(value = "EUREKA-CLIENT", fallback = ServiceFeignImpl.class) // 指定所要消费的服务名和断路回调对象
public interface ServiceFeign {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)     // 指定服务名下的接口
    String sayHello(@RequestParam(value = "name") String name);
}

/*
* 这里我的指定了fallback = ServiceFeignImpl.class，那么当调用接口的某个方法出现异常时，
* 由于采用了断路机制，会转向调用ServiceFeignImpl的实例中的对应相同的方法 */
