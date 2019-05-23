package com.credi.mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 2019/5/23.
 */
public class Mail {

    //发送邮件邮箱
    private String myMail = "??@163.com";
    //网易邮箱授权码
    private String pwd = "123";
    //收件人邮箱
    private String takeMail = "??@163.com";

    public void sendMail() throws MessagingException, UnsupportedEncodingException {

        //定义邮箱服务器配置对象
        Properties props = new Properties();
        // 设置163邮箱服务器地址
        props.put("mail.smtp.host","smtp.163.com");
        // 设置开启163邮箱服务器认证属性
        props.put("mail.smtp.auth","true");

        // 邮件的session会话
        Session session=Session.getInstance(props,
                new MyAuthenticator(myMail,pwd));//验证用户名和授权码

        //创建消息
        Message message = new MimeMessage(session);
        // 设置发送人地址
        message.setFrom(new InternetAddress(myMail));

        /**
         * 设置收件人邮箱 ,
         * 单发用setRecipient(RecipientType type, Address address),
         * 群发用setReplyTo(Address[] addresses)
         */
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(takeMail));

        // html邮件内容设置
        message.setSentDate(new Date());// 设置发送日期
        message.setSubject("java_mail 邮件标题");//设置邮件主题
        //message.setText("文本内容");// 1 .设置普通文本邮件内容

        // 2 . 设置html邮件的内容
        Multipart multipart=new MimeMultipart();
        BodyPart bodyPart=new MimeBodyPart();
        StringBuffer sb=new StringBuffer();
        sb.append("<html><body><a href='http://www.baidu.com'>百度一下</a></body></html>");
        bodyPart.setContent(sb.toString(), "text/html;charset=utf-8");
        multipart.addBodyPart(bodyPart);

        // 3. 添加邮件附件内容
        message.setContent(multipart);
        //添加附件内容
        BodyPart bodyPart02=new MimeBodyPart();// 内容体 附件
        FileDataSource fds=new FileDataSource(new File("D:/5月/源码/02-spring"));
        // 设置附件
        bodyPart02.setDataHandler(new DataHandler(fds));
        // 设置文件名
        bodyPart02.setFileName(MimeUtility.encodeText("spring源码解析.pdf"));
        multipart.addBodyPart(bodyPart02);
        message.setContent(multipart);

        Transport.send(message);// 发送邮件
    }
}
