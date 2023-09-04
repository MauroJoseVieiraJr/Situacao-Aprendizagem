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
@RequestMapping("situacao-aprendizagem/candidate")
public class CandidateController {
	private final CandidateRepository repository;
	
	public CandidateController(CandidateRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post")
	public void post(@RequestBody CandidateRequestDTO data) {
		Candidate c = new Candidate(data);
		repository.save(c);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/put")
	public void put(@RequestBody CandidateRequestDTO data) {
		Candidate c = new Candidate(data);
		
		Candidate a = repository.getReferenceById(data.id());
		a.update(c.getName(), c.getSex(), c.getRace(), c.getDisability(), c.getTelNumber(), c.getEmail(), c.getPostalCode(), c.getSkills());
				
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete")
	public void delete(@RequestBody CandidateRequestDTO data) {
		repository.deleteById(data.id());
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<CandidateResponseDTO> get() {
		List<CandidateResponseDTO> candidateList = repository.findAll().stream().map(CandidateResponseDTO::new).toList();
		return candidateList;
	}
}
