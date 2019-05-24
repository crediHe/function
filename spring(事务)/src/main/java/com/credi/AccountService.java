package com.credi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/24.
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    //以下注解为 事务操作以注解方式时使用
    //@Transactional(propagation= Propagation.REQUIRED)
    public void updateMoney(Double money,Integer outId,Integer inId){
        accountDao.outMoney(money,outId);
        int i = 1/0;
        accountDao.inMoney(money,inId);
    }
}
