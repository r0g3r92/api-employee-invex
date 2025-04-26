package com.invex.employee.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.invex.employee.domain.model.Employee;
import com.invex.employee.infrastructure.dao.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "idEmployee",target = "id")
    EmployeeEntity convertToEmployeeEntity(Employee employee);
    
    @Mapping(source = "id",target = "idEmployee")
    Employee convertToEmployee(EmployeeEntity employeeEntity);
}
