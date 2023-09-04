package com.senai.sc.SituacaoAprendizagem.dto.response;

import com.senai.sc.SituacaoAprendizagem.entity.Company;

public record CompanyResponseDTO(Long id, String name, String postalCode, String email, String password) {
	public CompanyResponseDTO (Company c) {
		this(c.getId(), c.getName(), c.getPostalCode(), c.getEmail(), c.getPassword());
	}
}
