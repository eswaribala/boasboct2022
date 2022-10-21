package com.boa.accountapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.accountapi.models.Account;
import com.boa.accountapi.repositories.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService{

	 @Autowired 
		private AccountRepo accountRepo;
		@Override
		public Account addAccount(Account Account) {
			// TODO Auto-generated method stub
			return this.accountRepo.save(Account);
		}

		@Override
		public List<Account> getAllAccounts() {
			// TODO Auto-generated method stub
			return this.accountRepo.findAll();
		}

		@Override
		public Account updateAccount(long accountNo, float roi, long odLimit) {
			// TODO Auto-generated method stub
			Account accountObj=this.accountRepo.findById(accountNo).orElse(null);
			if(accountObj!=null) {
				accountObj.setRoi(roi);
				accountObj.setOverDraftLimit(odLimit);
	            return this.accountRepo.save(accountObj);
	        }
			else
				return null;
			
		}

		@Override
		public boolean deleteAccountById(long customerId) {
			// TODO Auto-generated method stub
			boolean status=false;
			Account AccountObj=this.accountRepo.findById(customerId).orElse(null);
			if(AccountObj!=null)
			{
				this.accountRepo.deleteById(customerId);
			}
			AccountObj=this.accountRepo.findById(customerId).orElse(null);
			if(AccountObj==null)
			{
				status=true;
			}
			return status;
		}

		@Override
		public Account getAccountById(long customerId) {
			// TODO Auto-generated method stub
			return this.accountRepo.findById(customerId).orElse(null);
		}

}
