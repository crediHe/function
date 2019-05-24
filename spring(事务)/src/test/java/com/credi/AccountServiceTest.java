package com.credi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2019/5/24.
 */
public class AccountServiceTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        AccountService accountService = (AccountService) context.getBean("accountService");

        accountService.updateMoney(1.0,1,2);
    }

}