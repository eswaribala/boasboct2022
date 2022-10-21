package com.boa.customerapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class IndividualQueryResolver implements GraphQLQueryResolver{
	
	@Autowired
	private IndividualService individualService;

	public List<Individual> findAllIndividuals(){
	
		return individualService.getAllIndividuals();
	}
	
	public Individual findIndividual(long customerId) {
		return individualService.getIndividualById(customerId);
	}
}
