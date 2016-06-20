package com.emsws.employee.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsws.commons.exception.EntityAlreadyExistException;
import com.emsws.commons.exception.EntityNotFoundException;
import com.emsws.employee.domain.dto.RoleDTO;
import com.emsws.employee.domain.entity.RoleEntity;
import com.emsws.employee.domain.mapper.EmployeeMapper;
import com.emsws.employee.repository.RoleRepository;
import com.emsws.employee.service.RoleService;
import com.google.common.collect.Lists;
@Service
public class RoleServiceImplementation implements RoleService {
	
	@Autowired
	private RoleRepository dao;
	@Autowired
	private EmployeeMapper mapper;

	
	public RoleDTO getById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return mapper.map(dao.findOne(id), RoleDTO.class);
	}

	
	public RoleDTO saveOrUpdate(RoleDTO dto) throws EntityAlreadyExistException {
		// TODO Auto-generated method stub
		RoleEntity roleEntity = null;
		roleEntity = mapper.map(dto, RoleEntity.class);
		return mapper.map(dao.save(roleEntity), RoleDTO.class);
	}

	
	public void deleteById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	
	public List<RoleDTO> getAll() {
		// TODO Auto-generated method stub
		List<RoleDTO> listOfDTO = Lists.newArrayList();
		for(RoleEntity role:dao.findAll()){
			listOfDTO.add(mapper.map(role, RoleDTO.class));
		}
		return listOfDTO;
	}

}
