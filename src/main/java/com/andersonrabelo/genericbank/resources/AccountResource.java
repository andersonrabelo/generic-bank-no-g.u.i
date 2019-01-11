package com.andersonrabelo.genericbank.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andersonrabelo.genericbank.domain.Account;
import com.andersonrabelo.genericbank.services.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountResource {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public ResponseEntity<List<Account>> findAll() {

		List<Account> account = accountService.findAll();
		return ResponseEntity.ok().body(account);

	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Account> findById(@PathVariable String id) {

		Account account = accountService.findById(id);
		return ResponseEntity.ok().body(account);

	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Account obj) {

		Account account = accountService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {

		accountService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Account obj, @PathVariable String id) {

		obj.setId(id);
		obj = accountService.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}

}