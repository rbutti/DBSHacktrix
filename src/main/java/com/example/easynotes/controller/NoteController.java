package com.example.easynotes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.DefaulterList;
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
    
    @PostMapping("/login")
    public ResponseEntity getLoginDetails(@RequestBody LoginRequest login) {
    	
    	ResponseEntity<LoginRequest> re = new ResponseEntity<LoginRequest>(HttpStatus.ACCEPTED);
        return re;
    }
    
    @PostMapping("/createLoanRequest")
    public ResponseEntity createLoanRequest(@RequestBody LoanRequest loan) {
    	ResponseEntity<LoanRequest> re = new ResponseEntity<LoanRequest>(HttpStatus.ACCEPTED);
        return re;
    }
    
    @PostMapping("/getDefaulterList")
    public ResponseEntity createNote() {
    	ResponseEntity<DefaulterList> re = new ResponseEntity<DefaulterList>(HttpStatus.ACCEPTED);
    	return re;
    }
    
    @GetMapping("/getPersonDetails")
    public ResponseEntity<PersonDetails> getPersonDetails(@PathParam(value = "customerId") String customerId) {
    	PersonDetails  pr = new PersonDetails();
    	return ResponseEntity.ok(pr);
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
