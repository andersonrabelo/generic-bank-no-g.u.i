package com.andersonrabelo.genericbank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonrabelo.genericbank.domain.Adress;
import com.andersonrabelo.genericbank.exceptions.ObjectNotFoundException;
import com.andersonrabelo.genericbank.repository.AdressRepository;

@Service
public class AdressService {

	@Autowired
	private AdressRepository repository;

	public List<Adress> findAll() {
		return repository.findAll();
	}

	public Adress findById(String id) {
		Optional<Adress> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Adress insert(Adress obj) {
		return repository.insert(obj);
	}
}