package com.emsws.employee.webservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.emsws.commons.exception.EntityAlreadyExistException;
import com.emsws.commons.exception.EntityNotFoundException;
import com.emsws.employee.domain.dto.EmployeeDTO;
import com.emsws.employee.domain.dto.RoleDTO;
import com.emsws.employee.service.EmployeeService;
import com.emsws.employee.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	
	@RequestMapping(value="/roles/",method=RequestMethod.GET)
	public ResponseEntity<List<RoleDTO>> getAllRoles(){
		List<RoleDTO> roles = service.getAll();
		
		if(roles.isEmpty()){
			return new ResponseEntity<List<RoleDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RoleDTO>>(roles,HttpStatus.OK);
	}
	
	

	
}
