package com.andersonrabelo.genericbank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonrabelo.genericbank.domain.Client;
import com.andersonrabelo.genericbank.exceptions.ObjectNotFoundException;
import com.andersonrabelo.genericbank.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findById(String id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Client insert(Client obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Client update(Client obj) {
		Client newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		}

	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setBirthDate(obj.getBirthDate());
		newObj.setRg(obj.getRg());
		newObj.setCpf(obj.getCpf());
		newObj.setAdress(obj.getAdress());
		newObj.setJob(obj.getJob());
		newObj.setAverageIncome(obj.getAverageIncome());
		
	}
}