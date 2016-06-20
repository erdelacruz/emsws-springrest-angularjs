package com.emsws.employee.domain.mapper;

import org.springframework.context.annotation.Configuration;

import com.emsws.commons.mapper.OrikaBeanMapper;
import com.emsws.employee.domain.dto.EmployeeDTO;
import com.emsws.employee.domain.dto.RoleDTO;
import com.emsws.employee.domain.entity.EmployeeEntity;
import com.emsws.employee.domain.entity.RoleEntity;

import ma.glasnost.orika.MapperFactory;

@Configuration
public class EmployeeMapper extends OrikaBeanMapper {

	@Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        this.addAllSpringBeans(super.getApplicationContext());
        
        this.getFactory().classMap(EmployeeEntity.class, EmployeeDTO.class)
               .field("roles","roles")
                .field("contact.type", "contactType")
                .field("contact.contactNumber", "contactNumber")
                .field("address.street", "street")
                .field("address.barangay", "barangay")
                .field("address.city", "city")
                .field("address.houseNumber", "houseNumber")
                .field("address.subdivision", "subdivision")
                .field("address.zipCode", "zipCode")
                .byDefault()
                .register();
        
        this.getFactory().classMap(RoleEntity.class, RoleDTO.class)
        .byDefault()
        .register();

    }
}
