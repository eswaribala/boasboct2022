package com.boa.accountapi.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Accounts")
public class Account {
    @Id 
	private long accountNo;
	private long runningTotals;
	private String openDate;
	private float roi;
	private long overDraftLimit;
	private long customerId;
	
}
