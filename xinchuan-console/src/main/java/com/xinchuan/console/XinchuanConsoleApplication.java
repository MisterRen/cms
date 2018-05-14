package com.xinchuan.console;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class XinchuanConsoleApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XinchuanConsoleApplication.class, args);
    }

    @Value("classpath:menu.json")
    Resource resource;

    @Bean
    public Resource getResource(){
        return resource;
    }

}
