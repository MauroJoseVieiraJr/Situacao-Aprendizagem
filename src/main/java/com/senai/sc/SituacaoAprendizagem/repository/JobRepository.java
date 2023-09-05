package com.senai.sc.SituacaoAprendizagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.SituacaoAprendizagem.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
	List<Job> findJobByRole(String role);
	List<Job> findJobByActivities(String activities);
	List<Job> findJobByRequirements(String requirements);
}
