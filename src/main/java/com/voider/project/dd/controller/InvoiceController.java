package com.voider.project.dd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONObject;

import com.voider.project.dd.repository.InvoiceRepository;
//import com.voider.project.dd.util.UtilConstants;
import com.voider.project.dd.configuration.security.JWTProvider;
import com.voider.project.dd.model.Invoice;
import com.voider.project.dd.model.InvoiceDetail;
import com.voider.project.dd.repository.InvoiceDetailRepository;

@Controller
@RequestMapping("/invoice")
public class InvoiceController{
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;    
    @Autowired
    JWTProvider jwtProvider;
    @Autowired
    
    public static final Logger LOGGER = LoggerFactory.getLogger(InvoiceController.class);

    @RequestMapping(path="/{idInvoice}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoice> list(@PathVariable("idInvoice")Integer idInvoice){
        ResponseEntity<Invoice> response = null;
        Invoice invoice = null;
        HttpStatus status = null; 

        try {            
            
            invoice = invoiceRepository.get(idInvoice);
            status = HttpStatus.ACCEPTED;

        } catch (Exception e) {

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            e.printStackTrace();
            
        }
        response = ResponseEntity.status(status).body(invoice);

        return response;
    }

    @RequestMapping(method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insert(@RequestBody Invoice invoice,HttpServletRequest request){
        ResponseEntity<String> response = null;
        HttpStatus status = null; 
        JSONObject msg = new JSONObject();

        try {
            //Integer idUser = (Integer)jwtProvider.getClaims(request).get(UtilConstants.ID_USER);
            Integer idUser = 1;
            invoice.setIdUser(idUser);
            
            List<InvoiceDetail> details = new ArrayList<>();

            details.addAll(invoice.getDetails());
            
            invoice = invoiceRepository.save(invoice);
            
            for(InvoiceDetail detail : details){
                if(detail.getDeletedAt() == null){
                    detail.setIdInvoice(invoice.getIdInvoice());
                    invoiceDetailRepository.save(detail);
                }
            }

            msg.put("idInvoice", invoice.getIdInvoice());
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            msg.put("msg", "Error");
            e.printStackTrace();
            
        }
        response = ResponseEntity.status(status).body(msg.toString());

        return response;
    }
    
}