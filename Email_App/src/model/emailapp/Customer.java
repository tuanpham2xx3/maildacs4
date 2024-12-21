/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.emailapp;

/**
 *
 * @author Admin
 */
public class Customer {
    private String fullname;
    private String username;
    private String password;
    private String retypepass;

    public Customer() {
    }

    public Customer(String fullname, String username, String password, String retypepass) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.retypepass = retypepass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getRetypepass() {
        return retypepass;
    }

    public void setRetypepass(String retypepass) {
        this.retypepass = retypepass;
    }

}
