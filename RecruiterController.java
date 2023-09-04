package com.senai.sc.SituacaoAprendizagem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.sc.SituacaoAprendizagem.dto.request.RecruiterRequestDTO;
import com.senai.sc.SituacaoAprendizagem.dto.response.RecruiterResponseDTO;
import com.senai.sc.SituacaoAprendizagem.entity.Recruiter;
import com.senai.sc.SituacaoAprendizagem.repository.RecruiterRepository;

@RestController
@RequestMapping("situacao-aprendizagem/recruiter")
public class RecruiterController {
	private final RecruiterRepository repository;
	
	public RecruiterController(RecruiterRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post")
	public void post(@RequestBody RecruiterRequestDTO data) {
		Recruiter r = new Recruiter(data);
		repository.save(r);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/put")
	public void put(@RequestBody RecruiterRequestDTO data) {
		Recruiter r = new Recruiter(data);
		
		Recruiter a = repository.getReferenceById(data.id());
		a.update(r.getName(), r.getEmail(), r.getPassword());
				
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete")
	public void delete(@RequestBody RecruiterRequestDTO data) {
		repository.deleteById(data.id());
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<RecruiterResponseDTO> get() {
		List<RecruiterResponseDTO> recruiterList = repository.findAll().stream().map(RecruiterResponseDTO::new).toList();
		return recruiterList;
	}
}
