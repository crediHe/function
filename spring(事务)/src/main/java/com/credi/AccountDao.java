package com.credi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by xlf on 2018/9/8.
 */
@Repository
public class AccountDao {

    /***
     * 1. 出账
     * 2. 入账
     * */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 出账
     * @param money
     * @param outId
     * @return
     */
    public Integer outMoney(Double money, Integer outId){
        String sql = "update t_user set pwd=pwd-? where uid=?";
        return jdbcTemplate.update(sql,money, outId);
    }

    /**
     * 入账
     * @param money
     * @param inId
     * @return
     */
    public Integer inMoney(Double money, Integer inId){
        String sql = "update t_user set pwd=pwd+? where uid=?";
        return jdbcTemplate.update(sql,money, inId);
    }

}
