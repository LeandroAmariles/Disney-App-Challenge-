package com.disney.disneyproject.securityBad.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
//Controls the error when an unauthorized user wants to do something
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");

    }
}
