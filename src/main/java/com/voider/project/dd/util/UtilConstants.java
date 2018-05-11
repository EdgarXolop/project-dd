package com.voider.project.dd.util;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:infile.properties")
public class UtilConstants{
    /**
     * Util
     */
    public static final String FORMAT_DOUBLE  = "#.##";

    /**
     * Securiry config
     */
    public static final String LOGIN_PAGE= "/login";
    public static final String JWT_TOKEN = "Authorization";
    public static final String ID_USER = "idUser";
    public static final String ID_DEPARTAMENT = "idRole";
    public static final String DENIED_PAGE = "/denied/access";

}