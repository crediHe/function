package com.credi.service;

import com.credi.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 1 . 不能忘记标注@Component注解
 * 2 . 实现allbackFactory接口,并将要服务降级的API服务接口类作为泛型参数
 * 3 . 在create方法中返回服务降级的API服务接口的返回逻辑
 */
@Component
public class  DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            // 服务降级返回逻辑
            @Override
            public Dept get(Integer id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                dept.setDb_source("no this database in MySQL");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
