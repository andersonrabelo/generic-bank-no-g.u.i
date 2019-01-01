package com.andersonrabelo.genericbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonrabelo.genericbank.domain.Adress;
import com.andersonrabelo.genericbank.repository.AdressRepository;

@Service
public class AdressService {

	@Autowired
	private AdressRepository repository;
	
	public List<Adress> findAll() { 
		return repository.findAll();
	}
}