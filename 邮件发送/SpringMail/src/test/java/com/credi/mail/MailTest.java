package com.credi.mail;

import org.junit.Test;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2019/5/23.
 */
public class MailTest {

    @Test
    public void test() throws MessagingException, UnsupportedEncodingException {
        new Mail().sendMail();
    }

}