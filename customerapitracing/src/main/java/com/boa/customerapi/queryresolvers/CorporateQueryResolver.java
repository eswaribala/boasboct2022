package com.boa.customerapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class CorporateQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CorporateService corporateService;

	public List<Corporate> findAllCorporates(){
	
		return corporateService.getAllCorporates();
	}
	
	public Corporate findCorporate(long customerId) {
		return corporateService.getCorporateById(customerId);
	}
}
