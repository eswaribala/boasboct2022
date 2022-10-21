package com.boa.customerapi.controllers;

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

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;
import com.boa.customerapi.vos.ResponseWrapper;

@RestController
@RequestMapping("/corporates")
public class CorporateController {
	@Autowired 
	private CorporateService corporateService;
    
    @PostMapping({"/v1.0/"})
    public ResponseEntity<ResponseWrapper> addCorporate(@RequestBody Corporate Corporate){
    	
    	Corporate CorporateObj=this.corporateService.addCorporate(Corporate);
    	if(CorporateObj!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED)
    				.body(new ResponseWrapper(CorporateObj));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Corporate Input Not Correct"));
    	}
    }
    @GetMapping({"/v1.0/"})
    public List<Corporate> getCorporates(){
    	
    	return this.corporateService.getAllCorporates();
    }
    
    @PutMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> updateCorporate(@PathVariable("customerId") long customerId,
    		@RequestParam(name = "email") String email, 
			@RequestParam(name="password") String password){
    	
    	Corporate CorporateObj=this.corporateService.updateCorporate(customerId, password, email);
    	if(CorporateObj!=null) {
    		return ResponseEntity.status(HttpStatus.CREATED)
    				.body(new ResponseWrapper(CorporateObj));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Corporate Input Not Correct"));
    	}
    }
    
    @GetMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> getCorporateById(@PathVariable("customerId") 
          long customerId){
    	
    	Corporate CorporateObj=this.corporateService.getCorporateById(customerId);
    	if(CorporateObj!=null) {
    		return ResponseEntity.status(HttpStatus.ACCEPTED)
    				.body(new ResponseWrapper(CorporateObj));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Corporate Input Not Correct"));
    	}
    }
    @DeleteMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> deleteCorporateById(@PathVariable("customerId") 
          long customerId){
    	
    	
    	if(this.corporateService.deleteCorporateById(customerId)) {
    		return ResponseEntity.status(HttpStatus.ACCEPTED)
    				.body(new ResponseWrapper("Corporate Customer-->"+customerId+"==>deleted"));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseWrapper("Corporate Input Not Correct"));
    	}
    }
}
