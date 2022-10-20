package com.boa.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerapi.models.Individual;

public interface AddressRepo extends JpaRepository<Individual, Long>{

}
