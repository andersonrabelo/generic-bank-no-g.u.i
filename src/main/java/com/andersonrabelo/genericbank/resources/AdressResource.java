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

import com.andersonrabelo.genericbank.domain.Adress;
import com.andersonrabelo.genericbank.services.AdressService;

@RestController
@RequestMapping(value = "/adress")
public class AdressResource {

	@Autowired
	private AdressService adressService;

	@GetMapping
	public ResponseEntity<List<Adress>> findAll() {

		List<Adress> adress = adressService.findAll();
		return ResponseEntity.ok().body(adress);

	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Adress> findById(@PathVariable String id) {

		Adress adress = adressService.findById(id);
		return ResponseEntity.ok().body(adress);

	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Adress obj) {

		Adress adress = adressService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(adress.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {

		adressService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Adress obj, @PathVariable String id) {

		obj.setId(id);
		obj = adressService.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}

}