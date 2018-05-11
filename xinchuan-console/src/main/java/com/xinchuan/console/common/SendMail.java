package com.xinchuan.console.common;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 * 发送邮件
 */
public class SendMail {
    private MimeMessage message;
    private Session session;
    private Transport transport;

    private String mailHost = "mail.chinaebi.com";

    /*
     * 初始化方法
     */
    public SendMail() {

        Properties properties = System.getProperties();

        properties.put("mail.host", mailHost);
        // 开启ssl
        properties.put("mail.smtp.ssl.enable", "true");
        // 开启ssl后，所有的mail.smtp配置项需改为mail.smtps
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtps.port", "465");
        // 信任此域名
        properties.put("mail.smtps.ssl.trust", mailHost);

        session = Session.getDefaultInstance(properties, null);
        session.setDebug(false);// 开启后有调试信息
        message = new MimeMessage(session);
    }

    /**
     * 发送邮件
     *
     * @param subject     邮件主题
     * @param sendHtml    邮件内容
     * @param receiveUser 收件人地址
     */
    public void doSendHtmlEmail(String subject, String sendHtml,
                                String receiveUser) {
        try {
            // 发件人
            String sender_username = "vas.manage@chinaebi.com";
            InternetAddress from = new InternetAddress(sender_username);
            message.setFrom(from);

            // 收件人
            InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to);

            // 邮件主题
            message.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));

            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 添加邮件正文
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(sendHtml, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);

            // 将multipart对象放到message中
            message.setContent(multipart);

            transport = session.getTransport("smtps");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(mailHost, sender_username, "shdy11##");
            // 发送
            transport.sendMessage(message, message.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
