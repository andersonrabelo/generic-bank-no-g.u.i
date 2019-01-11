package com.andersonrabelo.genericbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andersonrabelo.genericbank.domain.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>{

}