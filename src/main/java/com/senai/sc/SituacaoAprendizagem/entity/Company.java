package com.senai.sc.SituacaoAprendizagem.entity;

import com.senai.sc.SituacaoAprendizagem.dto.request.CompanyRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "company")
@Entity(name = "company")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Company {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", columnDefinition = "varchar(255) not null")
	private String name;
	@Column(name = "postal_code", columnDefinition = "varchar(255) not null")
	private String postalCode;
	@Column(name = "email", columnDefinition = "varchar(255) not null")
	private String email;
	@Column(name = "password", columnDefinition = "varchar(255) not null")
	private String password;
	
	public Company() {}
	
	public Company(CompanyRequestDTO c) {
		this.name = c.name();
		this.postalCode = c.postalCode();
		this.email = c.email();
		this.password = c.password();
	}
	
	public void update(String name, String postalCode, String email, String password) {
		this.name = name;
		this.postalCode = postalCode;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
