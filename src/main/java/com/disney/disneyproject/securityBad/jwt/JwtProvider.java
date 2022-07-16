package com.disney.disneyproject.securityBad.jwt;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.disney.disneyproject.securityBad.entities.MainUser;

import java.util.Date;


@Component
public class JwtProvider {
    //logger to show errors
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    // Key to check the token
    @Value("${jwt.secret}")
    private String secret;

    // Base time of expiration
    @Value("${jwt.expiration}")
    private int expiration;
    // Make a token with the parameters in application.properties
    public String generateToken(Authentication authentication){
        MainUser mainUser = (MainUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date( new Date().getTime() + expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    //This method allow us get the name user from token
    public String GetUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    //Method to validated our token with the secret signature
    public boolean ValidateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e) {
            logger.error("Token was bad signed");
        } catch (UnsupportedJwtException e){
            logger.error("invalid token");
        }catch (ExpiredJwtException e){
            logger.error("Expired token");
        }catch(IllegalArgumentException e){
            logger.error("empty token");
        }catch (SignatureException e){
            logger.error("signature fail");
        }
        return false;
    }

}
