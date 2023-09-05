package com.senai.sc.SituacaoAprendizagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.SituacaoAprendizagem.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	List<Company> findCompanyByName(String name);
	List<Company> findCompanyByPostalCode(String postalCode);
	List<Company> findCompanyByEmail(String email);
}
