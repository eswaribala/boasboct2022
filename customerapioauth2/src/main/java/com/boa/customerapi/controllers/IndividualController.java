package com.boa.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import com.boa.customerapi.vos.ResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/individuals")
@Slf4j
public class IndividualController {
    @Autowired 
	private IndividualService individualService;
    
    @PostMapping({"/v1.0/"})
    public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){
    	
    	Individual individualObj=this.individualService.addIndividual(individual);
    	if(individualObj!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED)
    				.body(new ResponseWrapper(individualObj));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Individual Input Not Correct"));
    	}
    }
    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    @GetMapping({"/v1.0/"})
    public List<Individual> getIndividuals(){
    	SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		log.info("Scopes: " + authentication.getAuthorities());
		
    	return this.individualService.getAllIndividuals();
    }
    

	
	

    
    @PutMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> updateIndividual(@PathVariable("customerId") long customerId,
    		@RequestParam(name = "email") String email, 
			@RequestParam(name="password") String password){
    	
    	Individual individualObj=this.individualService.updateIndividual(customerId, password, email);
    	if(individualObj!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED)
    				.body(new ResponseWrapper(individualObj));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Individual Input Not Correct"));
    	}
    }
    
    @GetMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> getIndividualById(@PathVariable("customerId") 
          long customerId){
    	
    	Individual individualObj=this.individualService.getIndividualById(customerId);
    	if(individualObj!=null) {
    		return ResponseEntity.status(HttpStatus.ACCEPTED)
    				.body(new ResponseWrapper(individualObj));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Individual Input Not Correct"));
    	}
    }
    @DeleteMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> deleteIndividualById(@PathVariable("customerId") 
          long customerId){
    	
    	
    	if(this.individualService.deleteIndividualById(customerId)) {
    		return ResponseEntity.status(HttpStatus.ACCEPTED)
    				.body(new ResponseWrapper("Individual Customer-->"+customerId+"==>deleted"));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Individual Input Not Correct"));
    	}
    }
}
