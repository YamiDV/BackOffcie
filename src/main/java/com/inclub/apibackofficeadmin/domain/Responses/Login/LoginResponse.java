package com.inclub.apibackofficeadmin.domain.Responses.Login;

import java.util.Date;

import lombok.Getter;

public class LoginResponse {
    
    @Getter
    private String token;

    @Getter
    private  Date expiration;


    public LoginResponse() {
    }

    public LoginResponse(String token, Date expiration) {
        this.token = token;
        this.expiration = expiration;
    }
}
