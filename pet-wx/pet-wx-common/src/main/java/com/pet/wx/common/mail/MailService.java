package com.pet.wx.common.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    @Value("${mail.server}")
    private String mailServer;     //发送邮件的主机	
    @Value("${mail.port}")
    private String mailPort;       //端口
    @Value("${mail.fromaddress}")
    private String mailFromAddress; //发送者地址
    @Value("${mail.validate}")
    private boolean isValidate;     //是否需要认证
    @Value("${mail.username}")
    private String userName;       //用户名
    @Value("${mail.password}")
    private String passWord;       //密码

    /**
     * 发送邮件
     * @param type
     * @param toAddress
     * @param copyToMails
     * @return
     */
    public boolean sendMail(String[] toMails, String content,String subject) {
        SimpleMailSender sender = new SimpleMailSender();
        MailSenderInfo info = new MailSenderInfo();
        info.setMailServerHost(mailServer);
        info.setFromAddress(mailFromAddress);
        info.setMails(toMails);
        info.setUserName(userName);
        info.setPassword(passWord);
        info.setValidate(isValidate);
        info.setSubject(subject);
		info.setContent(content);
        return sender.sendTextMail(info);
    }

}
