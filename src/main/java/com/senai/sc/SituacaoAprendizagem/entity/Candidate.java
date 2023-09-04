package com.senai.sc.SituacaoAprendizagem.entity;

import com.senai.sc.SituacaoAprendizagem.dto.request.CandidateRequestDTO;

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

@Table(name = "candidate")
@Entity(name = "candidate")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@Column(name = "name", columnDefinition = "varchar(255) not null")
	private String name;
	@Column(name = "sex", columnDefinition = "varchar(255) not null")
	private String sex;
	@Column(name = "race", columnDefinition = "varchar(255) not null")
	private String race;
	@Column(name = "disability", columnDefinition = "varchar(255) not null")
	private String disability;
	@Column(name = "tel_number", columnDefinition = "varchar(255) not null")
	private String telNumber;
	@Column(name = "email", columnDefinition = "varchar(255) not null")
	private String email;
	@Column(name = "postal_code", columnDefinition = "varchar(255) not null")
	private String postalCode;
	@Column(name = "skills", columnDefinition = "varchar(255) not null")
	private String skills;
	
	public Candidate() {}
	
	public Candidate(CandidateRequestDTO c) {
		this.name = c.name();
		this.sex = c.sex();
		this.race = c.race();
		this.disability = c.disability();
		this.telNumber = c.telNumber();
		this.email = c.email();
		this.postalCode = c.postalCode();
		this.skills = c.skills();
	}
	
	public void update(String name, String sex, String race, String disability, String telNumber, String email, String postalCode, String skills) {
		this.name = name;
		this.sex = sex;
		this.race = race;
		this.disability = disability;
		this.telNumber = telNumber;
		this.email = email;
		this.postalCode = postalCode;
		this.skills = skills;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getRace() {
		return race;
	}
	public String getDisability() {
		return disability;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getSkills() {
		return skills;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public void setDisability(String disability) {
		this.disability = disability;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
}
