package com.disney.disneyproject.securityBad.DTO;

public class jwtDTO {

    private String token;

    public jwtDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
