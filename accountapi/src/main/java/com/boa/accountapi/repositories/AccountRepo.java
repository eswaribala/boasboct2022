package com.boa.accountapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boa.accountapi.models.Account;

public interface AccountRepo extends MongoRepository<Account,Long>{

}
