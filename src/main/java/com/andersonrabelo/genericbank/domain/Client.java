package com.andersonrabelo.genericbank.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andersonrabelo.genericbank.exceptions.DocumentFormatException;

@Document
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private Date birthDate;
	private String rg;
	private String cpf;
	private Adress adress;
	private String job;
	private Double averageIncome;

	public Client() {

	}

	public Client(String id, String name, Date birthDate, String rg, 
			String cpf, Adress adress, String job, Double averageIncome) {

		validateCPF(cpf);
		validateRG(rg);

		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.rg = rg;
		this.cpf = cpf;
		this.adress = adress;
		this.job = job;
		this.averageIncome = averageIncome;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getAverageIncome() {
		return averageIncome;
	}

	public void setAverageIncome(Double averageIncome) {
		this.averageIncome = averageIncome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Client other = (Client) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public static void validateCPF(String cpf) {

		if (cpf.length() != 14) {
			throw new DocumentFormatException("O formato correto do CPF é: 000.000.000-00");
		}
		if (!cpf.contains("-") && !cpf.contains(".")) {
			throw new DocumentFormatException("O formato correto do CPF é: 000.000.000-00");
		}

		String[] numCPF = cpf.split(".");
		String[] digCPF = numCPF[2].split("-");

		if (numCPF[0].length() != 3 || numCPF[0].length() != 3 || digCPF[0].length() != 3 || digCPF[1].length() != 2) {
			throw new DocumentFormatException("O formato correto do CPF é: 000.000.000-00");

		}

		if (!validateCPFDigit(cpf)) {
			throw new DocumentFormatException("CPF invalido!");
		}
	}

	public static void validateRG(String rg) {

		if (rg.length() != 9) {
			throw new DocumentFormatException("O formato correto do RG é: 00000000-0");
		}
		if (!rg.contains("-")) {
			throw new DocumentFormatException("O formato correto do RG é: 00000000-0");
		}

		String[] digRG = rg.split("-");

		if (digRG[0].length() != 7 || digRG[1].length() != 1) {
			throw new DocumentFormatException("O formato correto do RG é: 00000000-0");

		}

		if (!validateRGDigit(rg)) {
			throw new DocumentFormatException("RG invalido!");
		}

	}

	private static boolean validateRGDigit(String rg) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < rg.length(); i++) {
			if (rg.toUpperCase().charAt(i) == 'X') {
				list.add(0);
			} else if (rg.charAt(i) != '-') {
				list.add(Integer.parseInt(rg.substring(i, i + 1)));
			}
		}
		
		while (list.size() < 9) {
			list.add(0, 0);
		}

		int cont = 9;
		int sum = 0;
		for (int i = 0; i < (list.size() - 1); i++) {
			int x = list.get(i) * cont;
			sum += x;

			cont--;
		}
		sum = sum % 11;

		if (sum <= 1)
			list.add(0);
		else
			list.add(11 - sum);

		if (list.get(8) == list.get(9)) {
			return true;
		} else {
			return false;
		}
	}
	
	//----------------------------------------------------------
	public static boolean validateCPFDigit(String cpf) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 14; i++) {
			if (cpf.charAt(i) == '.') {}
			else if (cpf.charAt(i) == '-') {}
			else {
				list.add(Integer.parseInt(cpf.substring(i, i + 1)));
			}
		}

		for (int i = 0; i < 2; i++) {

			int sum = 0;
			int cont = 10 + i;
			for(int j=0; j<(list.size()-2); j++) {
				int x = list.get(j)*cont;
				sum += x;
				
				cont--;
			}
			
			sum = sum % 11;

			if (sum <= 2) list.add(0);
			else list.add(11 - sum);
		}

		if (list.get(9) == list.get(11) && list.get(10) == list.get(12)) {
			return true;
		} else {
			return false;
		}
	}
}
