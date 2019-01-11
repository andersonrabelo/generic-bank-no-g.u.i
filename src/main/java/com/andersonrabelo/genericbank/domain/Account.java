package com.andersonrabelo.genericbank.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
	
	@Id
	private String id;
	private String number;
	private String agency;
	private Date aperture;
	private Client titular;
	private Double balance;
	
	public Account() {
		
	}
	
	public Account(String id, String number, String agency, Date aperture, Client titular) {
		this.id = id;
		this.number = number;
		this.agency = agency;
		this.aperture = aperture;
		this.titular = titular;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Date getAperture() {
		return aperture;
	}

	public void setAperture(Date aperture) {
		this.aperture = aperture;
	}

	public Client getTitular() {
		return titular;
	}

	public void setTitular(Client titular) {
		this.titular = titular;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agency == null) ? 0 : agency.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Account other = (Account) obj;
		if (agency == null) {
			if (other.agency != null)
				return false;
		} else if (!agency.equals(other.agency))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
