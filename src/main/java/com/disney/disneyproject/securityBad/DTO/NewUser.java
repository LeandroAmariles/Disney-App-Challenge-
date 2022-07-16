package com.disney.disneyproject.securityBad.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class NewUser {

    @NotNull
    private String name;
    @NotNull
    private String userName;
    @Email
    private String mail;
    @NotNull
    private String password;
    private Set<String> roles = new HashSet<>();

    public NewUser(String name, String userName, String mail, String password, Set<String> roles) {
        this.name = name;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
