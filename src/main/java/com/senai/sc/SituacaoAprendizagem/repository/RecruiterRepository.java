package com.senai.sc.SituacaoAprendizagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.SituacaoAprendizagem.entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{
	// Aula 17 aos 13:40
	List<Recruiter> findRecruiterByName(String name);
	List<Recruiter> findRecruiterByEmail(String email);
}
