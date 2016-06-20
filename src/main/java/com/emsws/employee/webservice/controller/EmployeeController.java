package com.emsws.employee.webservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.emsws.commons.exception.EntityAlreadyExistException;
import com.emsws.commons.exception.EntityNotFoundException;
import com.emsws.employee.domain.dto.EmployeeDTO;
import com.emsws.employee.domain.dto.PrimaryKeyDTO;
import com.emsws.employee.domain.dto.SearchQueryDTO;
import com.emsws.employee.service.EmployeeService;
import com.google.common.collect.Lists;
/***
 * 
 * @author edelacruz
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	private List<EmployeeDTO> employees;
	private EmployeeDTO employee;
	
	/*** GET ALL EMPLOYEE HANDLER ***/
	@RequestMapping(value="/employee/",method=RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		System.out.println("FETCHING ALL EMPLOYEES");
		
		employees = service.getAll();
		if(employees.isEmpty()){
			return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeDTO>>(employees,HttpStatus.OK);
	}
	
	/*** SEARCH EMPLOYEE HANDLER ***/
	@RequestMapping(value="/search/employee/",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDTO>> getEmployeesByQuery(@RequestBody SearchQueryDTO query){
		
		employees = service.searchEmployeeBy(query);
		if(employees.isEmpty()){
			return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeDTO>>(employees,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/employee/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
		
		try {
			employee = service.getById(id);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmployeeDTO>(employee,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/employee/",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addEmployee(@Valid @RequestBody EmployeeDTO employee){

		try {
			employee = service.saveOrUpdate(employee);
		} catch (EntityAlreadyExistException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/employee/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDTO employeeFromRequest){
		System.out.println(id);
		System.out.println(employeeFromRequest.getId());
		try {
			employee = service.getById(id);
			if(employee!=null){
				service.saveOrUpdate(employeeFromRequest);
			}
		} catch (EntityNotFoundException e) {
			e.printStackTrace(); 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} catch (EntityAlreadyExistException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/employee/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
		
		try {
			service.deleteById(id);
		} catch (EntityNotFoundException e) {
			e.printStackTrace(); 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/batchdelete/",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> batchDeleteEmployee(@Valid @RequestBody List<PrimaryKeyDTO> primarykeys){
		
		try {
			for(PrimaryKeyDTO key:primarykeys){
				if(key!=null){
					service.deleteById(key.getId());
				}
			}
		} catch (EntityNotFoundException e) {
			e.printStackTrace(); 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e) {
	    List<ObjectError> errors = e.getBindingResult().getAllErrors();
	    return new ResponseEntity<String>(errors.get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
