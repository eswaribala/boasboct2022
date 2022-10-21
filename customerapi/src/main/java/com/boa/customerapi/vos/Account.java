package com.boa.customerapi.vos;

import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account {
 
	private long accountNo;
	private long runningTotals;
	private String openDate;
	private float roi;
	private long overDraftLimit;
    private AccountType accountType;
	private long customerId;
	
}
