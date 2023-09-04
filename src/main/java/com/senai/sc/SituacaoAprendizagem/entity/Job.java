package com.senai.sc.SituacaoAprendizagem.entity;

import com.senai.sc.SituacaoAprendizagem.dto.request.JobRequestDTO;

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

@Table(name = "job")
@Entity(name = "job")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "role", columnDefinition = "varchar(255) not null")
	private String role;
	@Column(name = "activities", columnDefinition = "varchar(255) not null")
	private String activities;
	@Column(name = "requirements", columnDefinition = "varchar(255) not null")
	private String requirements;
	
	public Job() {}
	
	public Job(JobRequestDTO j) {
		this.role = j.role();
		this.activities = j.activities();
		this.requirements = j.requirements();
	}

	public void update(String role, String activities, String requirements) {
		this.role = role;
		this.activities = activities;
		this.requirements = requirements;
	}

	public Long getId() {
		return id;
	}
	public String getRole() {
		return role;
	}
	public String getActivities() {
		return activities;
	}
	public String getRequirements() {
		return requirements;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public void setActivities(String activities) {
		this.activities = activities;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
}
