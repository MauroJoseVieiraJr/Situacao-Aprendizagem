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

import com.senai.sc.SituacaoAprendizagem.dto.request.CandidateRequestDTO;
import com.senai.sc.SituacaoAprendizagem.dto.response.CandidateResponseDTO;
import com.senai.sc.SituacaoAprendizagem.entity.Candidate;
import com.senai.sc.SituacaoAprendizagem.repository.CandidateRepository;

@RestController
@RequestMapping("candidate")
public class CandidateController {
	private final CandidateRepository repository;
	
	public CandidateController(CandidateRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void post(@RequestBody CandidateRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping
	public void put(@RequestBody CandidateRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping
	public void delete(@RequestBody CandidateRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<CandidateResponseDTO> get() {
		// TODO
		return null;
	}
}
