package com.andersonrabelo.genericbank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonrabelo.genericbank.domain.Account;
import com.andersonrabelo.genericbank.exceptions.ObjectNotFoundException;
import com.andersonrabelo.genericbank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public List<Account> findAll() {
		return repository.findAll();
	}

	public Account findById(String id) {
		Optional<Account> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Account insert(Account obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Account update(Account obj) {
		Account newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		}

	private void updateData(Account newObj, Account obj) {
		newObj.setBalance(obj.getBalance());
	}
}