package com.boa.accountapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.accountapi.models.Account;
import com.boa.accountapi.services.AccountService;
import com.boa.accountapi.vos.ResponseWrapper;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	  @Autowired 
		private AccountService accountService;
	    
	    @PostMapping({"/v1.0/"})
	    public ResponseEntity<ResponseWrapper> addAccount(@RequestBody Account Account){
	    	
	    	Account AccountObj=this.accountService.addAccount(Account);
	    	if(AccountObj!=null) {
	    		return ResponseEntity.status(HttpStatus.CREATED)
	    				.body(new ResponseWrapper(AccountObj));
	    	}
	    	else
	    	{
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	    				.body(new ResponseWrapper("Account Input Not Correct"));
	    	}
	    }
	    @GetMapping({"/v1.0/"})
	    public List<Account> getAccounts(){
	    	
	    	return this.accountService.getAllAccounts();
	    }
	    
	    @PutMapping({"/v1.0/{accountNo}"})
	    public ResponseEntity<ResponseWrapper> updateAccount(@PathVariable("accountNo") long accountNo,
	    		@RequestParam(name = "roi") float roi, 
				@RequestParam(name="odLimit") long odLimit){
	    	
	    	Account AccountObj=this.accountService.updateAccount(accountNo, roi, odLimit);
	    	if(AccountObj!=null) {
	    		return ResponseEntity.status(HttpStatus.CREATED)
	    				.body(new ResponseWrapper(AccountObj));
	    	}
	    	else
	    	{
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	    				.body(new ResponseWrapper("Account Input Not Correct"));
	    	}
	    }
	    
	    @GetMapping({"/v1.0/{accountNo}"})
	    public ResponseEntity<ResponseWrapper> getAccountById(@PathVariable("accountNo") 
	          long accountNo){
	    	
	    	Account AccountObj=this.accountService.getAccountById(accountNo);
	    	if(AccountObj!=null) {
	    		return ResponseEntity.status(HttpStatus.ACCEPTED)
	    				.body(new ResponseWrapper(AccountObj));
	    	}
	    	else
	    	{
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	    				.body(new ResponseWrapper("Account Input Not Correct"));
	    	}
	    }
	    @DeleteMapping({"/v1.0/{accountNo}"})
	    public ResponseEntity<ResponseWrapper> deleteAccountById(@PathVariable("accountNo") 
	          long accountNo){
	    	
	    	
	    	if(this.accountService.deleteAccountById(accountNo)) {
	    		return ResponseEntity.status(HttpStatus.ACCEPTED)
	    				.body(new ResponseWrapper("Account Customer-->"+accountNo+"==>deleted"));
	    	}
	    	else
	    	{
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	    				.body(new ResponseWrapper("Account Input Not Correct"));
	    	}
	    }
}
