package com.credi;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by Administrator on 2019/7/31.
 */
@SpringBootApplication
@EnableEurekaClient //使用该注解和Eureka整合,并声明是客户端
//标注该注解 , 启动指定微服务(MICROSERVICECLOUD-DEPT)时,就能去加载我们自定义的负载均衡类MyselfRule,从而使配置生效
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
