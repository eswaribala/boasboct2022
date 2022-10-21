package com.boa.customerapi.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AccountChannel {
	
	String outChannelName="account-out";
	
	@Output(outChannelName)
	MessageChannel outChannel();

}
