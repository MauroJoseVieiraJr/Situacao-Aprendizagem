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

import com.senai.sc.SituacaoAprendizagem.dto.request.JobRequestDTO;
import com.senai.sc.SituacaoAprendizagem.dto.response.JobResponseDTO;
import com.senai.sc.SituacaoAprendizagem.entity.Job;
import com.senai.sc.SituacaoAprendizagem.repository.JobRepository;

@RestController
@RequestMapping("job")
public class JobController {
	private JobRepository repository;
	
	public JobController(JobRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void post(@RequestBody JobRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping
	public void put(@RequestBody JobRequestDTO data) {
		// TODO
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping
	public void delete(@RequestBody JobRequestDTO data) {
		// TODO
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<JobResponseDTO> get() {
		// TODO
		return null;
	}
}
