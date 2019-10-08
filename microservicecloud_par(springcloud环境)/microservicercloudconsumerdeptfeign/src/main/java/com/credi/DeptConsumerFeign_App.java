package com.credi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2019/7/31.
 */
@SpringBootApplication
@EnableEurekaClient //使用该注解和Eureka整合,并声明是客户端
//@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class) //(1)Ribbon负载均衡+RestTemplate的方式标注该注解 , 启动指定微服务(MICROSERVICECLOUD-DEPT)时,就能去加载我们自定义的负载均衡类MyselfRule,从而使配置生效
@EnableFeignClients(basePackages= {"com.credi"}) // * (2)  Feign面向接口的消费服务方式
@ComponentScan("com.credi")
public class DeptConsumerFeign_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumerFeign_App.class, args);
    }
}
