package com.emsws.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsws.employee.domain.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
