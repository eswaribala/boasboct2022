package com.boa.customerapi.services;

import java.util.List;

import com.boa.customerapi.models.Individual;

public interface IndividualService {

	//Customer CRUD
	
	Individual addIndividual(Individual individual);
	List<Individual> getAllIndividuals();
	Individual updateIndividual(long customerId, String password, String email);
	boolean deleteIndividualById(long customerId);
	Individual getIndividualById(long customerId);
	
	
}
