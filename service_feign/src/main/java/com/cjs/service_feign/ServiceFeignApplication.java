package com.cjs.service_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient     // 作为服务发现者
@EnableFeignClients(basePackages = {"com.cjs.service_feign"})        // 开启feign功能,这里由于ServiceFeign接口就在此目录下
                                                                     // 可以省略该参数
@EnableHystrixDashboard   // 开启断路器仪表盘   启动应用后访问localhost:8765/hystrix,然后输入localhost:8765/hystrix.stream进入监控页面，title随便起
@EnableCircuitBreaker   // 此注解不能少，否则进入监控页面提示Unable to connect to Command Metric Stream
public class ServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignApplication.class, args);
	}
}
