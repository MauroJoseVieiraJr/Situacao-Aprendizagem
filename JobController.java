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
@RequestMapping("situacao-aprendizagem/job")
public class JobController {
	private JobRepository repository;
	
	public JobController(JobRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post")
	public void post(@RequestBody JobRequestDTO data) {
		Job j = new Job(data);
		repository.save(j);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/put")
	public void put(@RequestBody JobRequestDTO data) {
		Job j = new Job(data);
		
		Job a = repository.getReferenceById(data.id());
		a.update(j.getRole(), j.getActivities(), j.getRequirements());
				
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete")
	public void delete(@RequestBody JobRequestDTO data) {
		repository.deleteById(data.id());
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<JobResponseDTO> get() {
		List<JobResponseDTO> jobList = repository.findAll().stream().map(JobResponseDTO::new).toList();
		return jobList;
	}
}
