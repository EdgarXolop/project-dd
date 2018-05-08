package com.voider.project.dd.controller;

import javax.servlet.http.HttpServletRequest;

import com.voider.project.dd.configuration.security.JWTProvider;
import com.voider.project.dd.util.UtilConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import net.sf.json.JSONObject;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    JWTProvider jwtProvider;

    public static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    
    @RequestMapping(method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public ResponseEntity<String> indexView(HttpServletRequest request){
        ResponseEntity<String> response = null;
		HttpStatus status = null;			

        JSONObject resp = new JSONObject();
        
        status = HttpStatus.ACCEPTED;
        
        resp.put("application", "mbilling-myappsfotware");
		
        response = ResponseEntity.status(status).body(resp.toString());
        
        return response;
    }
    @RequestMapping(path=UtilConstants.DENIED_PAGE,method = {
        RequestMethod.DELETE,
        RequestMethod.GET,
        RequestMethod.HEAD,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.TRACE
    },produces="application/json")
    @ResponseBody
    public ResponseEntity<String> deniedAccess(HttpServletRequest request){
        ResponseEntity<String> response = null;
		HttpStatus status = null;
        String mail = jwtProvider.getClaims(request).getSubject();

        JSONObject resp = new JSONObject();
        
        status = HttpStatus.FORBIDDEN;

        LOGGER.warn("User <"+mail+"> try to access to unauthorized path");
        
        resp.put("error", "Access denied.");
		
        response = ResponseEntity.status(status).body(resp.toString());
        
        return response;
    }
}
