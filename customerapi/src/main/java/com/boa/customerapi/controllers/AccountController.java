package com.boa.customerapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.services.AccountPublisher;
import com.boa.customerapi.vos.Account;
import com.boa.customerapi.vos.ResponseWrapper;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
	private AccountPublisher accountPublisher;
    
    @PostMapping({"/v1.0/"})
    public ResponseEntity<ResponseWrapper> publishAccount(@RequestBody Account account){
    	
    	if(this.accountPublisher.publishCreateAccountData(account)) {
    		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("Account Published"));
    	}
    	else
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Account Not Published"));
    	
    }
    
}
