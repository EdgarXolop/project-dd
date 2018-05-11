package com.voider.project.dd;

import java.util.Arrays;

import com.voider.project.dd.configuration.CharsetFilter;
import com.voider.project.dd.configuration.security.JWTFilterConfigurer;
import com.voider.project.dd.configuration.security.JWTProvider;
import com.voider.project.dd.util.UtilConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private JWTProvider jwtProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        
        http.csrf().disable().cors().and();
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
            .authorizeRequests()
            //.antMatchers(UtilConstants.LOGIN_PAGE).permitAll()
            //.anyRequest().authenticated();
            .anyRequest().permitAll();
        
        http.exceptionHandling().accessDeniedPage(UtilConstants.DENIED_PAGE);

        http.addFilterBefore(new CharsetFilter(), UsernamePasswordAuthenticationFilter.class);
        
        http.apply(new JWTFilterConfigurer(jwtProvider));

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080","http://localhost:8081"));
        configuration.addExposedHeader("Authorization");
        
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
