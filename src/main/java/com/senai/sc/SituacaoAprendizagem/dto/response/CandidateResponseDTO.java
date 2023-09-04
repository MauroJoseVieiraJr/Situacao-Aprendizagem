package com.senai.sc.SituacaoAprendizagem.dto.response;

import com.senai.sc.SituacaoAprendizagem.entity.Candidate;

public record CandidateResponseDTO(Long id, String name, String sex, String race, String disability, String telNumber, String email, String postalCode, String skills) {
	public CandidateResponseDTO (Candidate c) {
		this(c.getId(), c.getName(), c.getSex(), c.getRace(), c.getDisability(), c.getTelNumber(), c.getEmail(), c.getPostalCode(), c.getSkills());
	}
}
