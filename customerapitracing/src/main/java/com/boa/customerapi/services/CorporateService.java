package com.boa.customerapi.services;

import java.util.List;

import com.boa.customerapi.models.Corporate;

public interface CorporateService {

	//Customer CRUD
	
		Corporate addCorporate(Corporate Corporate);
		List<Corporate> getAllCorporates();
		Corporate updateCorporate(long customerId,String email,String password);
		boolean deleteCorporateById(long customerId);
		Corporate getCorporateById(long customerId);
}
