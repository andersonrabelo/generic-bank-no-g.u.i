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

import com.andersonrabelo.genericbank.domain.Client;
import com.andersonrabelo.genericbank.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {

		List<Client> client = clientService.findAll();
		return ResponseEntity.ok().body(client);

	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Client> findById(@PathVariable String id) {

		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(client);

	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Client obj) {

		Client client = clientService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {

		clientService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Client obj, @PathVariable String id) {

		obj.setId(id);
		obj = clientService.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}

}