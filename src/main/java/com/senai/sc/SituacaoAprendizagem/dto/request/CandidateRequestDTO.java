package com.senai.sc.SituacaoAprendizagem.dto.request;

public record CandidateRequestDTO(Long id, String name, String sex, String race, String disability, String telNumber, String email, String postalCode, String skills) {
	
}
