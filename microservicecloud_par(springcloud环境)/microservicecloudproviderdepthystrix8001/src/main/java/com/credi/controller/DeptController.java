package com.credi.controller;


import com.credi.entities.Dept;
import com.credi.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController
{
    @Autowired
    private DeptService service = null;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    // * 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法(processHystrix_Get())
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Integer id)
    {

        Dept dept = this.service.get(id);

        // 为了测试 , 认为制造一个异常. 当指定id在数据库查询不到 , 抛出运行时异常
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }

        return dept;
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