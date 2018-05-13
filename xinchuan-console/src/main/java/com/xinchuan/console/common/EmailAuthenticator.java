package com.xinchuan.console.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * <p>
 *
 * </p>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月13日)
 * @version 1.0
 * @fileName EmailAuthenticator.java
 */
public class EmailAuthenticator extends Authenticator {

    private String user;
    private String pwd;
    public EmailAuthenticator() {
        super();
    }
    public EmailAuthenticator(String user, String pwd) {
        super();
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user,pwd);
    }
}
