package com.credi.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/7/31.
 */
@Configuration //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
public class ConfigBean {
    @Bean
    @LoadBalanced // * spring cloud ribbon是基于Netflix Ribbon实现的一套客户端负载均衡工具
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    // 轮循访问方式 , 可不配置,默认轮循
    @Bean
    public IRule myRule()
    {
        //return new RoundRobinRule();   //轮循
        return new RetryRule();   //轮循强化 ,会先执行轮循 , 如果有服务提供方宕机了, 且一定期间内仍然宕机 ,  会给宕机的服务打标记, 不会再做无用的访问
        //return new RandomRule();  //随机算法
        //return new AvailabilityFilteringRule();  // 首先过滤掉由于多次访问故障而处于断路器跳闸船台的服务还有并发的连接数量超过阈值的服务 ,然后对剩余的服务列表按照轮循策略进行访问
        //return new WeightedResponseTimeRule(); //根据平均乡音时间计算所有服务的权重 , 响应时间越快服务权重越大被选中的概率越高 . 刚启动时如果统计信息不足 , 则使用轮循策略,等统计信息足够,会切换到WeightedResponseTimeRule
        //return new BestAvailableRule(); //会先过滤掉由于多次访问鼓掌而处于断路器跳闸状态的服务 , 然后选择一个并发量最小的服务.
        //return new ZoneAvoidanceRule(); //默认规则,符合判断server所在区域的性能和server的可用性选择服务器.
    }
}
