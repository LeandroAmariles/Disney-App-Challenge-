package com.disney.disneyproject.securityBad.jwt;

import com.disney.disneyproject.securityBad.service.UserDetailServiceIMP;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JwtTokenFilter.class);

    private final JwtProvider jwtProvider;
    private final  UserDetailServiceIMP userDetailServiceIMP;

    @Autowired
    public JwtTokenFilter(JwtProvider jwtProvider, UserDetailServiceIMP userDetailServiceIMP) {
        this.jwtProvider = jwtProvider;
        this.userDetailServiceIMP = userDetailServiceIMP;
    }

    private String GetToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer"))
            return header.replace("Bearer", "");
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = GetToken(request);
            if(token != null && jwtProvider.ValidateToken(token)){
               String userName = jwtProvider.GetUserNameFromToken(token);
                UserDetails userDetails = userDetailServiceIMP.LoadUserByUsername(userName);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            }catch(Exception e ){
            logger.error(e.getMessage());

        }
        filterChain.doFilter(request, response);
    }
}
