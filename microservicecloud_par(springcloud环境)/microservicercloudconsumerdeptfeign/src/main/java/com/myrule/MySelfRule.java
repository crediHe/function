package com.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 自定义负载均衡类不能放在@ComponentScan所扫描的当前包及子包下
 * 也就是说自定义负载均衡类不能和主启动类在同一个包或者主启动类的子包下面
 */
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        return new RandomRule();// Ribbon默认是轮询，我自定义为随机
    }
}
