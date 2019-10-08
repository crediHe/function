package com.credi.service;

import com.credi.dao.DeptDao;
import com.credi.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
@Service
public class DeptService {
    @Autowired
    private DeptDao dao;

    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    public Dept get(Integer id)
    {
        return dao.findById(id);
    }

    public List<Dept> list()
    {
        return dao.findAll();
    }
}
