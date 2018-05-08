package com.voider.project.dd.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:infile.properties")
public class InfileProvider{

    @Value("${infile.company.nit}")
    public String COMPANY_NIT;
    @Value("${infile.company.name}")
    public String COMPANY_NAME;

    @Value("${infile.key}")
	public String KEY;
    @Value("${infile.user}")
    public String USER;
    
    @Value("${infile.country}")
    public String COUNTRY_NAME;

    @Value("${infile.regimen.2989}")
    public Boolean REGIMEN_2989;
    
    @Value("${infile.establishment}")
	public String ESTABLISHMENT;
    @Value("${infile.device}")
	public String DEVICE;
    @Value("${infile.gface}")
	public String GFACE;
    @Value("${infile.resolution.number}")
	public String RESOLUTION_NUMBER;
    @Value("${infile.resolution.year}")
	public Integer RESOLUTION_YEAR; 
    @Value("${infile.resolution.month}") 
	public Integer RESOLUTION_MONTH;
    @Value("${infile.resolution.day}")
    public Integer RESOLUTION_DAY;
    
    @Value("${infile.serie}")
    public String SERIE;
    @Value("${infile.doc.type}")
    public String DOC_TYPE;
    @Value("${infile.doc.number}")
    public String DOC_TYPE_NUMBER;
    @Value("${infile.doc.status.active}")
    public String DOC_STATUS_ACTIVE;
}