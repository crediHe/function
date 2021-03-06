package com.credi.controller;

import com.credi.entities.Dept;
import com.credi.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/7/31.
 */
@RestController
public class DeptController_Consumer {

    /**
     * (2)Feign面向接口的消费服务方式
     */

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }

    /**
     * (1)Ribbon负载均衡+RestTemplate的服务消费方式
     */
    // 服务注册中心
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    // * 使用Ribbon负载均衡时 , 需要使用服务注册中心注册的真实服务名作为URL访问服务(非服务别名)
    // private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
//    /**
//     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
//     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
//     */
//    @Autowired
//    private RestTemplate restTemplate; // springcloud基于RESTful API调用而非RPC
//
//    @RequestMapping(value = "/consumer/dept/add")
//    public boolean add(Dept dept)
//    {
//        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class); //REST请求地址、请求参数、HTTP响应转换被转换成的对象类型(返回值类型)。
//    }
//
//    @RequestMapping(value = "/consumer/dept/get/{id}")
//    public Dept get(@PathVariable("id") Long id)
//    {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
//    }
//
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/consumer/dept/list")
//    public List<Dept> list()
//    {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
//    }
//
//    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
//    @RequestMapping(value = "/consumer/dept/discovery")
//    public Object discovery()
//    {
//        // 调用服务注册中心的服务
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
//    }

}
