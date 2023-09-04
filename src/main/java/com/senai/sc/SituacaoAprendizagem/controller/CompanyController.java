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
@RequestMapping("company")
public class CompanyController {
	private CompanyRepository repository;
	
	public CompanyController(CompanyRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void post(@RequestBody CompanyRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping
	public void put(@RequestBody CompanyRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping
	public void delete(@RequestBody CompanyRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<CompanyResponseDTO> get() {
		// TODO
		return null;
	}
}
