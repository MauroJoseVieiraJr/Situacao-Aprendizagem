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

import com.senai.sc.SituacaoAprendizagem.dto.request.CompanyRequestDTO;
import com.senai.sc.SituacaoAprendizagem.dto.response.CompanyResponseDTO;
import com.senai.sc.SituacaoAprendizagem.entity.Company;
import com.senai.sc.SituacaoAprendizagem.repository.CompanyRepository;

@RestController
@RequestMapping("situacao-aprendizagem/company")
public class CompanyController {
	private CompanyRepository repository;
	
	public CompanyController(CompanyRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post")
	public void post(@RequestBody CompanyRequestDTO data) {
		Company c = new Company(data);
		repository.save(c);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/put")
	public void put(@RequestBody CompanyRequestDTO data) {
		Company c = new Company(data);
		
		Company a = repository.getReferenceById(data.id());
		a.update(c.getName(), c.getPostalCode(), c.getEmail(), c.getPassword());
				
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PatchMapping("/patch")
	public void patch(	@RequestParam(name = "id", required = true) long id,
						@RequestParam(name = "name", required = false) String name,
						@RequestParam(name = "postalCode", required = false) String postalCode,
						@RequestParam(name = "email", required = false) String email) {
		Company c = repository.getReferenceById(id);
		
		if (name != null)
			c.setName(name);
		
		if (postalCode != null)
			c.setPostalCode(postalCode);
		
		if (email != null)
			c.setEmail(email);

		repository.save(c);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {	
		repository.deleteById(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<CompanyResponseDTO> get() {
		List<CompanyResponseDTO> companyList = repository.findAll().stream().map(CompanyResponseDTO::new).toList();
		return companyList;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyid")
	public ResponseEntity<Company> getById(@RequestParam(name = "id", required = true) long id) {
		try {
			Optional<Company> c = repository.findById(id);
			
			if (Optional.ofNullable(c).isPresent())
				return new ResponseEntity<Company>(c.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Company>(new Company(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Company>(new Company(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyparam")
	public ResponseEntity<List<Company>> getByParam(@RequestParam(name = "name", required = false) String name,
													@RequestParam(name = "postalCode", required = false) String postalCode,
													@RequestParam(name = "email", required = false) String email) {
		// A busca aqui tem que ser EXATA
		try {
			List<Company> cName = repository.findCompanyByName(name);
			List<Company> cPostalCode = repository.findCompanyByPostalCode(postalCode);
			List<Company> cEmail = repository.findCompanyByEmail(email);
			List<Company> result = new ArrayList<Company>();
			
			result.addAll(cName);
			result.addAll(cPostalCode);
			result.addAll(cEmail);
			
			if (!result.isEmpty())
				return new ResponseEntity<List<Company>>(result, HttpStatus.OK);
			else
				return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<Company>>(HttpStatus.BAD_REQUEST);
		}
	}
}
