package com.aca.careercenter.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by mainserver on 4/24/2017
 */
@ManagedBean(name = "loginController", eager = true)
@SessionScoped
public class LoginController {

    private String username;
    private String password;

    public LoginController() {

    }

    public void login(){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
