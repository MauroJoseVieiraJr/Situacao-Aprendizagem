package com.senai.sc.SituacaoAprendizagem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.sc.SituacaoAprendizagem.dto.request.CompanyRequestDTO;
import com.senai.sc.SituacaoAprendizagem.dto.response.CompanyResponseDTO;
import com.senai.sc.SituacaoAprendizagem.entity.Company;
import com.senai.sc.SituacaoAprendizagem.repository.CompanyRepository;

@RestController
@RequestMapping("situacao-aprendizagem/company")
public class CompanyController {
	private CompanyRepository repository;
	
	public CompanyController(CompanyRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post")
	public void post(@RequestBody CompanyRequestDTO data) {
		Company c = new Company(data);
		repository.save(c);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/put")
	public void put(@RequestBody CompanyRequestDTO data) {
		Company c = new Company(data);
		
		Company a = repository.getReferenceById(data.id());
		a.update(c.getName(), c.getPostalCode(), c.getEmail(), c.getPassword());
				
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete")
	public void delete(@RequestBody CompanyRequestDTO data) {
		repository.deleteById(data.id());
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<CompanyResponseDTO> get() {
		List<CompanyResponseDTO> companyList = repository.findAll().stream().map(CompanyResponseDTO::new).toList();
		return companyList;
	}
}
