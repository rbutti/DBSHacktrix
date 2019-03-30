package com.example.easynotes.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.dao.CreateLoanRequestDaoImpl;
import com.example.easynotes.dao.DefaulterDetailsDao;
import com.example.easynotes.dao.DefaulterDetailsDaoImpl;
import com.example.easynotes.dao.EmailNotificationDaoImpl;
import com.example.easynotes.dao.LoginDAOImpl;
import com.example.easynotes.dao.PersonalDAOimpl;
import com.example.easynotes.model.DefaulterList;
import com.example.easynotes.model.EmailRequestDetails;
import com.example.easynotes.model.LoanDetails;
import com.example.easynotes.model.LoanRequest;
import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.PersonDetails;

/**
 * Created by ArnabSarkar on 30/03/19.
 */
@RestController
@RequestMapping("/api")
public class NoteController {
	
	@Autowired
	LoginDAOImpl dao;
	
	@Autowired
	CreateLoanRequestDaoImpl loanReq;
	
		
	@Autowired
	PersonalDAOimpl dao1;
	
	@Autowired
	EmailNotificationDaoImpl emailReq; 
	
	@Autowired
	DefaulterDetailsDaoImpl defaulterReq;
    
    @PostMapping("/login")
    public ResponseEntity getLoginDetails(@RequestBody LoginRequest login) {
    	return ResponseEntity.ok(dao.login(login));
    }
    
    @PostMapping("/login")
    public ResponseEntity sendEmailNotification(@RequestBody EmailRequestDetails emailDetails) {
    	emailReq.emailRequestDetails(emailDetails);
    	return ResponseEntity.ok("SUCCESS");
    }
    
    @PostMapping("/createLoanRequest")
    public ResponseEntity createLoanRequest(@RequestBody LoanRequest loan) {
    	LoanRequest loanRes = loanReq.createNewLoanRequest(loan);
    	EmailRequestDetails emailReq = new EmailRequestDetails();
    	emailReq.setToEmail(loanRes.getCustomerEmail());
    	emailReq.setMessageTitle("Loan Status");
    	emailReq.setMessageBody("Your Request has been Submitted. Please wait for the Approval.");
    	sendEmailNotification(emailReq);
    	ResponseEntity<LoanRequest> re = new ResponseEntity<LoanRequest>(HttpStatus.ACCEPTED);
        return re;
    }
    
    @PostMapping("/getDefaulterList")
    public ResponseEntity createNote() {
    	List<DefaulterList> defList = defaulterReq.getDefaulterList();
    	ResponseEntity<List<DefaulterList>> re = new ResponseEntity<List<DefaulterList>>(HttpStatus.ACCEPTED);
    	return re;
    }
    
    @GetMapping("/getPersonDetails")
    public ResponseEntity<PersonDetails> getPersonDetails(@PathParam(value = "customerId") String customerId) {
    	PersonDetails  pr = new PersonDetails();
    	
    	PersonDetails dt=dao1.getPersonalDetails(customerId);
    	
    	return ResponseEntity.ok(dt);
    }
    
    @GetMapping("/getLoanDetails")
    public ResponseEntity<LoanDetails> getLoanDetails(@PathParam(value = "customerId") String customerId) {
    	LoanDetails  pr = new LoanDetails();
    	return ResponseEntity.ok(pr);
    }
    
    @GetMapping("/getUserDetails")
    public ResponseEntity<LoanDetails> getUserDetails(@PathParam(value = "userId") String userId) {
    	LoanDetails  pr = new LoanDetails();
    	return ResponseEntity.ok(pr);
    }
}
