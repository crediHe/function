package com.credi.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 验证用户名和授权码
 */
public class MyAuthenticator extends Authenticator{
    private String uname;
    private String pwd;

    public MyAuthenticator(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    //重写getPasswordAuthentication方法
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(uname,pwd);
    }
}
