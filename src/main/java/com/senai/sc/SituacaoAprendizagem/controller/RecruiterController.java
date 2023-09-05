package com.senai.sc.SituacaoAprendizagem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PatchMapping("/patch")
	public void patch(	@RequestParam(name = "id", required = true) long id,
						@RequestParam(name = "name", required = false) String name,
						@RequestParam(name = "email", required = false) String email,
						@RequestParam(name = "password", required = false) String password) {
		// Para testar esse método use:
		// localhost:8080/situacao-aprendizagem/recruiter/patch?id=1&name=NOME&email=EMAIL@DOMINIO.COM&password=SEGREDO
		Recruiter r = repository.getReferenceById(id);
		
		if (name != null)
			r.setName(name);
		
		if (email != null)
			r.setEmail(email);
		
		if (password != null)
			r.setPassword(password);

		repository.save(r);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {	
		repository.deleteById(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<RecruiterResponseDTO> get() {
		List<RecruiterResponseDTO> recruiterList = repository.findAll().stream().map(RecruiterResponseDTO::new).toList();
		return recruiterList;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyid")
	public ResponseEntity<Recruiter> getById(@RequestParam(name = "id", required = true) long id) {
		// Aula 16 aos 32:14
		try {
			Optional<Recruiter> r = repository.findById(id);
			
			if (Optional.ofNullable(r).isPresent())
				return new ResponseEntity<Recruiter>(r.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Recruiter>(new Recruiter(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Recruiter>(new Recruiter(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyparam")
	public ResponseEntity<List<Recruiter>> getByParam(	@RequestParam(name = "name", required = false) String name,
														@RequestParam(name = "email", required = false) String email) {
		// A busca aqui tem que ser EXATA
		try {
			List<Recruiter> rName = repository.findRecruiterByName(name);
			List<Recruiter> rEmail = repository.findRecruiterByEmail(email);
			List<Recruiter> result = new ArrayList<Recruiter>();
			
			result.addAll(rName);
			result.addAll(rEmail);
			
			if (!result.isEmpty())
				return new ResponseEntity<List<Recruiter>>(result, HttpStatus.OK);
			else
				return new ResponseEntity<List<Recruiter>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<Recruiter>>(HttpStatus.BAD_REQUEST);
		}
	}
}
