package com.voider.project.dd.configuration.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voider.project.dd.util.UtilConstants;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JWTFilter extends GenericFilterBean{

    private JWTProvider jwtProvider;

    public JWTFilter(JWTProvider jwtProvider){
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = jwtProvider.resolveToken(httpRequest);
        
        token = (token != null && token.length() > 0) ? token : null;

        if((token != null && jwtProvider.validateToken(token)) 
            || "OPTIONS".equalsIgnoreCase(httpRequest.getMethod())
            || UtilConstants.LOGIN_PAGE.equals(httpRequest.getServletPath())){

            Authentication auth = token != null ? jwtProvider.getAuthentication(token)  : null;
            SecurityContextHolder.getContext().setAuthentication(auth);
            chain.doFilter(request, response);
        }else{
            
            httpResponse.addHeader("Access-Control-Allow-Origin", "*");
            httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
            httpResponse.addHeader("Access-Control-Allow-Headers", "Authorization,Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,");
            httpResponse.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials,Authorization");
            httpResponse.addHeader("Access-Control-Allow-Credentials", "true");

            httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

            httpResponse.getWriter().write("{\"msg\",\"Invalid token.\"}");
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        }
    }

}