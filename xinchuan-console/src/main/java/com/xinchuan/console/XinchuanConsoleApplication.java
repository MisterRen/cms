package com.xinchuan.console;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.DispatcherServlet;
import sun.misc.IOUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class XinchuanConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinchuanConsoleApplication.class, args);
    }

    @Value("classpath:menu.json")
    Resource resource;

    @Bean
    public Resource getResource(){
        return resource;
    }

/*    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("*.htm");
        return registration;
    }*/
}
