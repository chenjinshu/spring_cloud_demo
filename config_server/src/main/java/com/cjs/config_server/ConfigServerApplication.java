package com.cjs.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer     // 作为配置服务器
@EnableEurekaClient     // 作为服务提供者
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	/*
	* 启动应用后，在浏览器地址栏输入http://localhost:8888/config-client/dev/master时，
	* 应用程序会去加载配置文件中指定的git仓库中指定分支中的配置文件，这里也就是
	* 会返回master分支下的config-client-dev.properties配置文件的内容
	* 项目刚启动时访问地址可能会提示仓库无法检出，过一会儿就可以了 */
}
