package com.credi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Administrator on 2019/8/2.
 */
@SpringBootApplication
@EnableHystrixDashboard //豪猪监控所需注解
public class DeptConsumer_DashBoard_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
    }
}
