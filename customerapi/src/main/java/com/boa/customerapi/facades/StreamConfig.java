package com.boa.customerapi.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(AccountChannel.class)
public class StreamConfig {

}
