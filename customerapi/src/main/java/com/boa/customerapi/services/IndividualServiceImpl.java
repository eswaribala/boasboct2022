package com.boa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepo;
@Service
public class IndividualServiceImpl implements IndividualService{
    @Autowired 
	private IndividualRepo individualRepo;
	@Override
	public Individual addIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return this.individualRepo.save(individual);
	}

	@Override
	public List<Individual> getAllIndividuals() {
		// TODO Auto-generated method stub
		return this.individualRepo.findAll();
	}

	@Override
	public Individual updateIndividual(long customerId, String password, String email) {
		// TODO Auto-generated method stub
		Individual individualObj=this.individualRepo.findById(customerId).orElse(null);
		if(individualObj!=null) {
			individualObj.setEmail(email);
			individualObj.setPassword(password);
            return this.individualRepo.save(individualObj);
        }
		else
			return null;
		
	}

	@Override
	public boolean deleteIndividualById(long customerId) {
		// TODO Auto-generated method stub
		boolean status=false;
		Individual individualObj=this.individualRepo.findById(customerId).orElse(null);
		if(individualObj!=null)
		{
			this.individualRepo.deleteById(customerId);
		}
		individualObj=this.individualRepo.findById(customerId).orElse(null);
		if(individualObj==null)
		{
			status=true;
		}
		return status;
	}

	@Override
	public Individual getIndividualById(long customerId) {
		// TODO Auto-generated method stub
		return this.individualRepo.findById(customerId).orElse(null);
	}

}
