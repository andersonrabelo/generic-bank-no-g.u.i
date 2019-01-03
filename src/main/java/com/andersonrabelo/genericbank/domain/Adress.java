package com.andersonrabelo.genericbank.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andersonrabelo.genericbank.exceptions.AdressFormatException;

@Document
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String street;
	private Integer number;
	private String neighborhood;
	private String city;
	private String state;
	private String country;
	private String complement;
	private String cep;
	
	public Adress() {
		
	}

	public Adress(String id, String street, Integer number, 
			String neighborhood, String city, String state, 
			String country, String complement, String cep) {
		
		cepValidate(cep);
		
		this.id = id;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.complement = complement;
		this.cep = cep;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public static void cepValidate(String cep) {
		if (cep.length() != 9) {
			throw new AdressFormatException("O formato correto do CEP é: 00000-000");
		}
		if (!cep.contains("-")) {
			throw new AdressFormatException("O formato correto do CEP é: 00000-000");
		}
		
		String[] numCep = cep.split("-");
		
		if(numCep[0].length() != 5 || numCep[1].length() != 3 ) {
			throw new AdressFormatException("O formato correto do CEP é: 00000-000");
		}
		
	}
}