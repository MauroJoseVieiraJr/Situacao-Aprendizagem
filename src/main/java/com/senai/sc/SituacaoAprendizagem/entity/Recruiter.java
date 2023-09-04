package com.senai.sc.SituacaoAprendizagem.entity;

import com.senai.sc.SituacaoAprendizagem.dto.request.RecruiterRequestDTO;

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

@Table(name = "recruiter")
@Entity(name = "recruiter")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", columnDefinition = "varchar(255) not null")
	private String name;
	@Column(name = "email", columnDefinition = "varchar(255) not null")
	private String email;
	@Column(name = "password", columnDefinition = "varchar(255) not null")
	private String password;
	
	public Recruiter() {}
	
	public Recruiter(RecruiterRequestDTO r) {
		this.name = r.name();
		this.email = r.email();
		this.password = r.password();
	}
	
	public void update(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
