package com.andersonrabelo.genericbank.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonrabelo.genericbank.domain.Adress;
import com.andersonrabelo.genericbank.services.AdressService;

@RestController
@RequestMapping(value="/adress")
public class AdressResource {
	
	@Autowired
	private AdressService adressService;

	@GetMapping
	public ResponseEntity<List<Adress>> findAll() {
		
		List<Adress> adress = adressService.findAll();	
		return ResponseEntity.ok().body(adress);
		
	}
}