package com.senai.sc.SituacaoAprendizagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.SituacaoAprendizagem.entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{

}
