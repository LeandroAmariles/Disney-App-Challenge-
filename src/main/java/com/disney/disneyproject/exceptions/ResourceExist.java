package com.disney.disneyproject.exceptions;

public class ResourceExist extends RuntimeException{

    private String email;

    public ResourceExist(String email){
        super(String.format("%s email already exist"));
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
