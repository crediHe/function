package com.credi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2019/7/30.
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //使用该注解,注册进服务中心的服务才能够被其他模块服务发现
@EnableCircuitBreaker// * 对hystrix熔断机制的支持
public class DeptProvider8002_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8002_App.class, args);
    }
}