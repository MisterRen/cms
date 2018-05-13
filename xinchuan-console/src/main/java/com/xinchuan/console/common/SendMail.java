package com.xinchuan.console.common;

import com.sun.mail.util.MailSSLSocketFactory;
import com.xinchuan.console.model.XcConsult;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * 发送邮件
 */
@Component
public class SendMail {
    // 邮箱服务器
    private String host = "smtp.qq.com";

    private String username ="2904037708@qq.com";//发件人

    private String password ="pwmduujrwlvydcgb";//授权码

    private String mail_head_name = "来自传信官网咨询";

    private String mail_head_value = "来自传信官网咨询";

    //private String mail_to = "liny@infomax.net.cn";//收件人
    private String mail_to = "my.love.beijing@163.com";//收件人

    private String mail_subject = "客户联系信息";

    private String mail_body = "邮件内容";

    private String personalName = "邮件主题";


    /**
     * 此段代码用来发送普通电子邮件
     *
     */
    public void send(XcConsult xcConsult) {
        try {
            mail_subject = xcConsult.getUserName();
            personalName = "来自传信官网咨询";
            mail_body = "<p>姓名："+xcConsult.getUserName()+"</p><p>电话："+xcConsult.getUserPhone()+"</p>" +
                        "<p>邮箱："+xcConsult.getUserEmail()+"</p><p>需求："+xcConsult.getRemarks()+"</p>";
            Properties props = new Properties();
            Authenticator auth = new EmailAuthenticator(username,password); // 进行邮件服务器用户认证
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            props.put("mail.transport.protocol", "smtp");
            MailSSLSocketFactory sf = new MailSSLSocketFactory();//ssl设置
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
            Session session = Session.getDefaultInstance(props, auth);
            // 设置session,和邮件服务器进行通讯。
            MimeMessage message = new MimeMessage(session);
            // message.setContent("foobar, "application/x-foobar"); // 设置邮件格式
            message.setContent(mail_body , "text/html;charset=utf-8");
            message.setSubject(mail_subject); // 设置邮件主题
            //message.setText(mail_body); // 设置邮件正文
            message.setHeader(mail_head_name, mail_head_value); // 设置邮件标题
            message.setSentDate(new Date()); // 设置邮件发送日期
            Address address = new InternetAddress(username, personalName);
            message.setFrom(address); // 设置邮件发送者的地址
            Address toAddress = new InternetAddress(mail_to); // 设置邮件接收方的地址
            message.addRecipient(Message.RecipientType.TO, toAddress);
            Transport.send(message); // 发送邮件
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
