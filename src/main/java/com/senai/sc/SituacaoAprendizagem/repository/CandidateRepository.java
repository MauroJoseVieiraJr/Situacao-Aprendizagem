package com.senai.sc.SituacaoAprendizagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.SituacaoAprendizagem.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
}
