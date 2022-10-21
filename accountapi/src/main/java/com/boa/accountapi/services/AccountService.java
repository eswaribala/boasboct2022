package com.boa.accountapi.services;

import java.util.List;

import com.boa.accountapi.models.Account;



public interface AccountService {
	Account addAccount(Account Account);
	List<Account> getAllAccounts();
	Account updateAccount(long accountNo, float roi, long odLimit);
	boolean deleteAccountById(long accountNo);
	Account getAccountById(long accountNo);

}
