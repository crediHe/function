package com.credi.service;

import com.credi.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 服务注册中心 , 服务提供方microservicecloudprovider-dept-8001,microservicecloudprovider-dept-8002,microservicecloudprovider-dept-8003模块
 * 提供服务的API模块接口类
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT") //指明接口所对应的服务
// * 服务降级要在@FeignClient注解中配置fallbackFactory属性值 , 该属性值为针对指定服务(MICROSERVICECLOUD-DEPT)服务降级的处理逻辑类
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Integer id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);
}
