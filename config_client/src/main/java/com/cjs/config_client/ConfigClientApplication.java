package com.cjs.config_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	/*首先启动rabbitmq。
	*
	* 当启动应用时，应用会请求配置中心config_server，然后配置中心根据应用中的
	* 应用名称，文件类型 ，所在分支
	* 来加载指定的配置文件，在这里，就相当于访问
	* http://localhost:8888/config-client/dev/master, 然后
	* 配置中心把获取到的数据再返回给应用
	*
	* 启动应用后，访问localhost:8881/hi看结果 */
}
