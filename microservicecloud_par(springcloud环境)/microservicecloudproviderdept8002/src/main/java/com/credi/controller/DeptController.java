package com.credi.controller;

import com.credi.entities.Dept;
import com.credi.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    // * 注入DiscoveryClient , 用于服务发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Integer id)
    {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }

    //	@Autowired
//	private DiscoveryClient client;
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        // 打印所有注册的服务
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        // 是否有MICROSERVICECLOUD-DEPT的服务
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            // 有的话输出服务id,ip,端口,URL
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

    // 服务熔断处理逻辑
    public Dept processHystrix_Get(@PathVariable("id") Integer id)
    {
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
        dept.setDb_source("no this database in MySQL");
        return dept;
    }
}
