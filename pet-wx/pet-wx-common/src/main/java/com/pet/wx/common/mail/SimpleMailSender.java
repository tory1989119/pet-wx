package com.pet.wx.common.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class SimpleMailSender {
    /**
     * 以文本格式发送邮件
     * 
     * @param mailInfo
     *            待发送的邮件的信件
     */
    public boolean sendTextMail(MailSenderInfo mailInfo) {
        String[] ms = mailInfo.getMails();
        boolean result = false;
        if (ms != null && ms.length != 0) {// 有邮件接收时才去发送邮件，否则无法发送

            MailAuthenticator authenticator = null;
            Properties pro = mailInfo.getProperties();
            if (mailInfo.isValidate()) {// 判断是否需要身份认证

                authenticator = new MailAuthenticator(mailInfo.getUserName(),
                    mailInfo.getPassword()); // 需要身份认证，则创建一个密码验证器
            }
            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
            try {
                // 根据session创建一个邮件消息
                MimeMessage mailMessage = new MimeMessage(sendMailSession);
                // 创建邮件发送者地址
                Address from = new InternetAddress(mailInfo.getFromAddress());
                // 设置邮件消息的发送者
                mailMessage.setFrom(from);
                // 创建邮件的接收者地址，并设置到邮件消息中
                Address[] ccAdresses = new InternetAddress[ms.length];
                for (int i = 0, j = ms.length; i < j; i++) {
                    ccAdresses[i] = new InternetAddress(ms[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.TO, ccAdresses);
                // 设置邮件消息的主题
                mailMessage.setSubject(mailInfo.getSubject());
                // 设置邮件消息发送的时间
                mailMessage.setSentDate(new Date());
                // 设置邮件消息的主要内容
                String mailContent = mailInfo.getContent();
                mailMessage.setText(mailContent);
                // 发送邮件
                Transport.send(mailMessage);

                result = true;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return result;
    }

}