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
    public static final String GTQ = "GTQ";

    /**
     * Securiry config
     */
    public static final String JWT_TOKEN = "Authorization";
    public static final String ID_USER = "idUser";
    public static final String ID_DEPARTAMENT = "idDepartament";
    public static final String LOGIN_PAGE = "/login/auth";
    public static final String DENIED_PAGE = "/denied/access";

    public static final String ROLE_DESAROLLO = "DESARROLLO";
    public static final String ROLE_INGENIERIA = "INGENIERIA";
    public static final String ROLE_VENTAS = "VENTAS";
    public static final String ROLE_OPERACIONES = "OPERACIONES";
    public static final String ROLE_TELEMERCADEO = "TELEMERCADEO";

    public static final String CAE_URL		        = "https://www.ingface.net/Ingfacereport/dtefactura.jsp?cae=%s";
    public static final String INGFACE_URL          = "https://www.ingface.net/listener/ingface";
    public static final String INGFACE_WSDL_URL     = "https://www.ingface.net/listener/ingface?wsdl";
    public static final String INGFACE_WSDL_SOAP_ACTION_REGISTRAR_DTE = "http://listener.ingface.com/ingface/registrarDteRequest";
    public static final String INGFACE_WSDL_SOAP_ACTION_RESPONSE_DTE = "http://listener.ingface.com/ingface/registrarDteResponse";
    
    public static final String PRD_AS_SERVICE       = "S";
    public static final String PRD_AS_PROPERTY      = "B";

    public static final String EMPTY_VALUE          = "";
    public static final String N_A                  = "N/A";

    public static final Double ZERO_VALUE           = 0.0d;

    public static final String EXCHANGE_RATE_MSG    = "Tipo de cambio Q ";
    public static final String SERVICE_DATE         = "Factura por servicios prestados en ";

    public static final String[] MONTHS             = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
}