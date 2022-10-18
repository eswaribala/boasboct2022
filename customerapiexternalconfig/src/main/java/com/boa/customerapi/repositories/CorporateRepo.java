package com.boa.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.models.Individual;

public interface CorporateRepo extends JpaRepository<Corporate, Long>{

}
