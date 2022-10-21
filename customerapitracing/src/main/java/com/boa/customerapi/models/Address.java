package com.boa.customerapi.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ForeignKey;
@Entity
@Table(name="Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Address_Id",nullable = false, length = 200)
	@ApiModelProperty(hidden = true)
	private long addressId;
	@Column(name="Door_No",nullable = false, length = 5)
	private String doorNo;
	@Column(name="Street_Name",nullable = false, length = 150)
	private String streetName;
	@Column(name="City",nullable = false, length = 150)
	private String city;
	@Column(name="Pincode")
	private long pincode;	

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Customer_Id"), name = "Customer_Id")
	private Customer customer;

}
