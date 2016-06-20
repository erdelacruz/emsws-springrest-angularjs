package com.emsws.employee.domain.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class PrimaryKeyDTO implements Serializable {
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
