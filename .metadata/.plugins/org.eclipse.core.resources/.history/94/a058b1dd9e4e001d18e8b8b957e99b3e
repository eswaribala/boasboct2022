package com.boa.customerapi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class ResponseWrapper<T> {
	private String version;
	private String message;
	private T payload;
	public ResponseWrapper(String version, String message) {
		super();
		this.version = version;
		this.message = message;
	}
	public ResponseWrapper(T payload) {
		super();
		this.payload = payload;
	}

	
}
