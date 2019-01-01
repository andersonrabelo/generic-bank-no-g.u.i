package com.andersonrabelo.genericbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andersonrabelo.genericbank.domain.Adress;

@Repository
public interface AdressRepository extends MongoRepository<Adress, String>{

}