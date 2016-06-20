package com.emsws.employee.domain.dto;

import java.io.Serializable;

import javax.persistence.*;

public class RoleDTO implements Serializable {
	
	private Long id;
	private String roleName;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
