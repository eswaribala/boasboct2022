package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName {
    @Column(name="First_Name",nullable = false, length = 50) 
	private String firstName;
    @Column(name="Last_Name",nullable = false, length = 50) 
	private String lastName;
    @Column(name="Middle_Name",nullable = true, length = 50) 
	private String middleName; 
}
