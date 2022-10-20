package com.boa.customerapi.services;

import java.util.List;

import com.boa.customerapi.models.Address;

public interface AddressService {

	//Address CRUD	
			Address addAddress(Address Address);
			List<Address> getAllAddresss();
			Address updateAddress(Address address);
			boolean deleteAddressById(long addressId);
			Address getAllAddressById(long addressId);
}
