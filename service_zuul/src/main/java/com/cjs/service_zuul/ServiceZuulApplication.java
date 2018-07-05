package com.cjs.service_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy       // 开启zuul功能
//@EnableEurekaClient   // 作为服务提供者
@EnableDiscoveryClient  // 作为服务的发现者      // 这里使用这个注解和上一个注解貌似没什么区别。。。
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}

	// 启动eureka_server,eurka_client,service_feign,service_ribbon,service_zuul五个服务后，打开浏览器
    // 输入http://localhost:8769/api-a/hello?name=cjs，由于受到过滤器的作用，会提示token is empty！
    // 请求将不会转发到service_ribbon服务中，当我们再添加token参数后，输入http://localhost:8769/api-a/hello?name=cjs&token=ppp
    // 则请求就会被转发到service_ribbon服务中
    // zuul不仅可以作为请求转发服务，也能提供服务过滤的功能
}
