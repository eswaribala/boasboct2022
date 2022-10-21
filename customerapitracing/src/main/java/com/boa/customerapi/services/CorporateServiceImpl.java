package com.boa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.repositories.CorporateRepo;
@Service
public class CorporateServiceImpl implements CorporateService {

	 @Autowired 
     private CorporateRepo corporateRepo;
	 
		@Override
		public Corporate addCorporate(Corporate Corporate) {
			// TODO Auto-generated method stub
			return this.corporateRepo.save(Corporate);
		}

		@Override
		public List<Corporate> getAllCorporates() {
			// TODO Auto-generated method stub
			return this.corporateRepo.findAll();
		}

		@Override
		public Corporate updateCorporate(long customerId, String password, String email) {
			// TODO Auto-generated method stub
			Corporate corporateObj=this.corporateRepo.findById(customerId).orElse(null);
			if(corporateObj!=null) {
				corporateObj.setEmail(email);
				corporateObj.setPassword(password);
	            return this.corporateRepo.save(corporateObj);
	        }
			else
				return null;
			
		}

		@Override
		public boolean deleteCorporateById(long customerId) {
			// TODO Auto-generated method stub
			boolean status=false;
			Corporate corporateObj=this.corporateRepo.findById(customerId).orElse(null);
			if(corporateObj!=null)
			{
				this.corporateRepo.deleteById(customerId);
			}
			corporateObj=this.corporateRepo.findById(customerId).orElse(null);
			if(corporateObj==null)
			{
				status=true;
			}
			return status;
		}

		@Override
		public Corporate getCorporateById(long customerId) {
			// TODO Auto-generated method stub
			return this.corporateRepo.findById(customerId).orElse(null);
		}
}
