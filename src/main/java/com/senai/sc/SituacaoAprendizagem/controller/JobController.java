package com.senai.sc.SituacaoAprendizagem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PatchMapping("/patch")
	public void patch(	@RequestParam(name = "id", required = true) long id,
						@RequestParam(name = "role", required = false) String role,
						@RequestParam(name = "activities", required = false) String activities,
						@RequestParam(name = "requirements", required = false) String requirements) {
		Job j = repository.getReferenceById(id);
		
		if (role != null)
			j.setRole(role);
		
		if (activities != null)
			j.setActivities(activities);
		
		if (requirements != null)
			j.setRequirements(requirements);

		repository.save(j);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public void delete(@RequestParam("id") long id) {	
		repository.deleteById(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<JobResponseDTO> get() {
		List<JobResponseDTO> jobList = repository.findAll().stream().map(JobResponseDTO::new).toList();
		return jobList;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyid")
	public ResponseEntity<Job> getById(@RequestParam(name = "id", required = true) long id) {
		try {
			Optional<Job> j = repository.findById(id);
			
			if (Optional.ofNullable(j).isPresent())
				return new ResponseEntity<Job>(j.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Job>(new Job(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Job>(new Job(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyparam")
	public ResponseEntity<List<Job>> getByParam(@RequestParam(name = "role", required = false) String role,
												@RequestParam(name = "activities", required = false) String activities,
												@RequestParam(name = "requirements", required = false) String requirements) {
		// A busca aqui tem que ser EXATA
		try {
			List<Job> jRole = repository.findJobByRole(role);
			List<Job> jActivities = repository.findJobByActivities(activities);
			List<Job> jRequirements = repository.findJobByRequirements(requirements);
			List<Job> result = new ArrayList<Job>();
			
			result.addAll(jRole);
			result.addAll(jActivities);
			result.addAll(jRequirements);
			
			if (!result.isEmpty())
				return new ResponseEntity<List<Job>>(result, HttpStatus.OK);
			else
				return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<Job>>(HttpStatus.BAD_REQUEST);
		}
	}
}
