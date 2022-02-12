package com.modefair.portal.domain;

import java.io.Serializable;

public class LoginForm implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
