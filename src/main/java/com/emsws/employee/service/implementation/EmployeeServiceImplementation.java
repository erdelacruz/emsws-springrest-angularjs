package com.emsws.employee.service.implementation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emsws.commons.exception.EntityAlreadyExistException;
import com.emsws.commons.exception.EntityNotFoundException;
import com.emsws.employee.domain.dto.EmployeeDTO;
import com.emsws.employee.domain.dto.SearchQueryDTO;
import com.emsws.employee.domain.entity.EmployeeEntity;
import com.emsws.employee.domain.mapper.EmployeeMapper;
import com.emsws.employee.repository.EmployeeRepository;
import com.emsws.employee.service.EmployeeService;
import com.google.common.collect.Lists;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	private EmployeeRepository dao;
	@Autowired
    private EmployeeMapper mapper;
	
	
	@Transactional
	public EmployeeDTO getById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		EmployeeEntity employee =dao.findOne(id);
		
		if(employee==null){
			throw new EntityNotFoundException(ENTITY_NOT_FOUND_MSG);
		}
		return mapper.map(employee, EmployeeDTO.class);
	}

	
	@Transactional
	public EmployeeDTO saveOrUpdate(EmployeeDTO dto) throws EntityAlreadyExistException {
		// TODO Auto-generated method stub
		
		if(dto.getId()==null){
			int existingEmployeeCount = dao.countByFirstnameAndLastnameAndMiddlename(dto.getFirstname(), dto.getLastname(), dto.getMiddlename()).size();
			if(existingEmployeeCount>0){
				throw new EntityAlreadyExistException(ENTITY_ALREADY_EXIST_MSG);
			}
		}
		EmployeeEntity entity = mapper.map(dto, EmployeeEntity.class);
		return mapper.map(dao.save(entity), EmployeeDTO.class);
	}

	
	@Transactional
	public void deleteById(Long id) throws EntityNotFoundException {
		EmployeeEntity employee =dao.findOne(id);
		if(employee==null){
			throw new EntityNotFoundException(ENTITY_NOT_FOUND_MSG);
		}
		dao.delete(employee);
	}

	
	@Transactional
	public List<EmployeeDTO> getAll() {
		List<EmployeeDTO> listOfDTO = Lists.newArrayList();
		for(EmployeeEntity  entity:dao.findAllOrderByFirstnameAsc()){
			listOfDTO.add(mapper.map(entity, EmployeeDTO.class));
		}
		
		return listOfDTO;
	}


	public List<EmployeeDTO> searchEmployeeBy(SearchQueryDTO query) {
		List<EmployeeDTO> listOfDTO = Lists.newArrayList();
		for(EmployeeEntity  entity:dao.findBy(query.getFirstname(), query.getLastname(), query.getMiddlename(), query.getRoleId())){
			listOfDTO.add(mapper.map(entity, EmployeeDTO.class));
		}
		return listOfDTO;
	}
	
	

	
	

	

}
