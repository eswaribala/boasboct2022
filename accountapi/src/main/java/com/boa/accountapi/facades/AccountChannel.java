package com.boa.accountapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface AccountChannel {

	String channelName="account-in";
	@Input(channelName)
	MessageChannel inChannel();
}
