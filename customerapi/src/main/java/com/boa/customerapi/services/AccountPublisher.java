package com.boa.customerapi.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.messaging.support.MessageBuilder;
import com.boa.customerapi.facades.AccountChannel;
import com.boa.customerapi.vos.Account;

@Service
public class AccountPublisher {
    @Autowired
	private AccountChannel accountChannel;
    
    
    public boolean publishCreateAccountData(Account account) {
    	
    	MessageChannel messageChannel= accountChannel.outChannel();
    	LocalDate localDate=LocalDate.parse(account.getOpenDate());
    	
    	if(localDate.isBefore(LocalDate.now()))
    		return false;
    	else
    	{
    	return messageChannel.send(MessageBuilder
                .withPayload(account)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    	}

    }
    
}
