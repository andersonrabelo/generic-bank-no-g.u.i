package com.andersonrabelo.genericbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andersonrabelo.genericbank.domain.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{

}