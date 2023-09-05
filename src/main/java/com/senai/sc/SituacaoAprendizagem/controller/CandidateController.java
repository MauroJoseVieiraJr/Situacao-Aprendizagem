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
	@PatchMapping("/patch")
	public void patch(	@RequestParam(name = "id", required = true) long id,
						@RequestParam(name = "name", required = false) String name,
						@RequestParam(name = "sex", required = false) String sex,
						@RequestParam(name = "race", required = false) String race,
						@RequestParam(name = "disability", required = false) String disability,
						@RequestParam(name = "telNumber", required = false) String telNumber,
						@RequestParam(name = "email", required = false) String email,
						@RequestParam(name = "postalCode", required = false) String postalCode,
						@RequestParam(name = "skills", required = false) String skills) {
		Candidate c = repository.getReferenceById(id);
		
		if (name != null)
			c.setName(name);
				
		if (sex != null)
			c.setSex(sex);
		
		if (race != null)
			c.setRace(race);
		
		if (disability != null)
			c.setDisability(disability);
		
		if (telNumber != null)
			c.setTelNumber(telNumber);
		
		if (email != null)
			c.setEmail(email);
		
		if (postalCode != null)
			c.setPostalCode(postalCode);
		
		if (skills != null)
			c.setSkills(skills);

		repository.save(c);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {	
		repository.deleteById(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<CandidateResponseDTO> get() {
		List<CandidateResponseDTO> candidateList = repository.findAll().stream().map(CandidateResponseDTO::new).toList();
		return candidateList;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyid")
	public ResponseEntity<Candidate> getById(@RequestParam(name = "id", required = true) long id) {
		try {
			Optional<Candidate> c = repository.findById(id);
			
			if (Optional.ofNullable(c).isPresent())
				return new ResponseEntity<Candidate>(c.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Candidate>(new Candidate(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Candidate>(new Candidate(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyparam")
	public ResponseEntity<List<Candidate>> getByParam(	@RequestParam(name = "name", required = false) String name,
														@RequestParam(name = "sex", required = false) String sex,
														@RequestParam(name = "race", required = false) String race,
														@RequestParam(name = "disability", required = false) String disability,
														@RequestParam(name = "telNumber", required = false) String telNumber,
														@RequestParam(name = "email", required = false) String email,
														@RequestParam(name = "postalCode", required = false) String postalCode,
														@RequestParam(name = "skills", required = false) String skills) {
		// A busca aqui tem que ser EXATA
		try {
			List<Candidate> cName = repository.findCandidateByName(name);
			List<Candidate> cSex = repository.findCandidateByEmail(sex);
			List<Candidate> cRace = repository.findCandidateByEmail(race);
			List<Candidate> cDisability = repository.findCandidateByEmail(disability);
			List<Candidate> cTelNumber = repository.findCandidateByEmail(telNumber);
			List<Candidate> cEmail = repository.findCandidateByEmail(email);
			List<Candidate> cPostalCode = repository.findCandidateByPostalCode(postalCode);
			List<Candidate> cSkills = repository.findCandidateByEmail(skills);
			List<Candidate> result = new ArrayList<Candidate>();
			
			result.addAll(cName);
			result.addAll(cSex);
			result.addAll(cRace);
			result.addAll(cDisability);
			result.addAll(cTelNumber);
			result.addAll(cEmail);
			result.addAll(cPostalCode);
			result.addAll(cSkills);
			
			if (!result.isEmpty())
				return new ResponseEntity<List<Candidate>>(result, HttpStatus.OK);
			else
				return new ResponseEntity<List<Candidate>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<Candidate>>(HttpStatus.BAD_REQUEST);
		}
	}
}
