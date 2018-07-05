package com.cjs.service_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient     // 作为服务的发现者(消费者)
@EnableHystrix   // 开启Hystrix断路机制
@EnableHystrixDashboard   // 开启断路器仪表盘  启动应用后访问localhost:8764/hystrix
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
    @LoadBalanced      // 开启负载均衡
	public RestTemplate restTemplate() {
	    return new RestTemplate();
    }
}
