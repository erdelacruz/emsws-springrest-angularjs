package com.emsws.employee.service;

import java.util.List;

import com.emsws.commons.service.GenericService;
import com.emsws.employee.domain.dto.EmployeeDTO;
import com.emsws.employee.domain.dto.SearchQueryDTO;

public interface EmployeeService extends GenericService<EmployeeDTO,Long> {
	public List<EmployeeDTO> searchEmployeeBy(SearchQueryDTO query);
}
