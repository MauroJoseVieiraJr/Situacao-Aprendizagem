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

import com.senai.sc.SituacaoAprendizagem.dto.request.RecruiterRequestDTO;
import com.senai.sc.SituacaoAprendizagem.dto.response.RecruiterResponseDTO;
import com.senai.sc.SituacaoAprendizagem.entity.Recruiter;
import com.senai.sc.SituacaoAprendizagem.repository.RecruiterRepository;

@RestController
@RequestMapping("recruiter")
public class RecruiterController {
	private final RecruiterRepository repository;
	
	public RecruiterController(RecruiterRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void post(@RequestBody RecruiterRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping
	public void put(@RequestBody RecruiterRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping
	public void delete(@RequestBody RecruiterRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<RecruiterResponseDTO> get() {
		// TODO
		return null;
	}
}
