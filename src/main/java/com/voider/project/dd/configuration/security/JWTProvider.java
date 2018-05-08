package com.voider.project.dd.configuration.security;

import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import com.voider.project.dd.model.User;
import com.voider.project.dd.util.UtilConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@PropertySource("classpath:application.properties")
public class JWTProvider{
    
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Value("${security.jwt.token.secretkey}")
    private String secretKey;
    
    @Value("${security.jwt.token.expirelength}")
    private long expirelength = 3600000;
    
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(User user){
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + expirelength);

        claims.put("idUser", user.getIdUser());
        claims.put("idRole", user.getIdRole());

        return Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(now)
                    .setExpiration(expiredDate)
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(getEmail(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
    }
    
    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest httpServletRequest){
        String bearerToken = httpServletRequest.getHeader(UtilConstants.JWT_TOKEN);

        return bearerToken;
    }
    

    public Claims getClaims(HttpServletRequest httpServletRequest){
        Claims Claims = null;
        try {
            Claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(resolveToken(httpServletRequest)).getBody();
        } catch (Exception   e) {
            e.printStackTrace();
            Logger.getLogger(JWTProvider.class.getName()).log(Level.SEVERE, "{0}",HttpStatus.UNAUTHORIZED.toString());
        }
        return Claims;
    }

    public Boolean validateToken(String token){
        Boolean valid = false;

        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
            valid = true;
        } catch (Exception   e) {
            e.printStackTrace();
            Logger.getLogger(JWTProvider.class.getName()).log(Level.SEVERE, "{0}",HttpStatus.UNAUTHORIZED.toString());
        }
        
        return valid;
    }
}