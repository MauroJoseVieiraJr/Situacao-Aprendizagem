package com.senai.sc.SituacaoAprendizagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.SituacaoAprendizagem.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	List<Candidate> findCandidateByName(String name);
	List<Candidate> findCandidateBySex(String sex);
	List<Candidate> findCandidateByRace(String race);
	List<Candidate> findCandidateByDisability(String disability);
	List<Candidate> findCandidateByTelNumber(String telNumber);
	List<Candidate> findCandidateByEmail(String email);
	List<Candidate> findCandidateByPostalCode(String postalCode);
	List<Candidate> findCandidateBySkills(String skills);
}
