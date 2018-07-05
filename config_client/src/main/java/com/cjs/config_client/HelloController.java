package com.cjs.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${foo}")
    private String foo;       // 注入配置文件中的foo变量

    @RequestMapping("/hi")
    public String hi() {
        return foo;
    }
}
