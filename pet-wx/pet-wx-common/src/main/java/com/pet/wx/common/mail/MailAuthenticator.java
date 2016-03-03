package com.pet.wx.common.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * 邮件认证器
 * 
 * @author wuzhixuan
 * @version $Id: MailAuthenticator.java, v 0.1 2015年6月5日 下午3:08:08  Exp $
 */
public class MailAuthenticator extends Authenticator {

    String userName = null;
    String password = null;

    public MailAuthenticator() {
    }

    public MailAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}