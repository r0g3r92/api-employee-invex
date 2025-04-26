package com.invex.employee.adapter.out.persistence.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.invex.employee.domain.model.Employee;
import com.invex.employee.domain.port.out.employee.CreateEmployeeRepositoryPort;
import com.invex.employee.infrastructure.dao.entity.EmployeeEntity;
import com.invex.employee.infrastructure.dao.repository.EmployeeRepository;
import com.invex.employee.infrastructure.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateEmployeePersistence implements CreateEmployeeRepositoryPort{


    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public boolean createEmployee(List<Employee> listEmployee) {
        log.info("Init process to mapper employee objects to save.");
        List<EmployeeEntity> listEmployeeSave = listEmployee
                            .stream()
                            .map(employeeMapper::convertToEmployeeEntity)
                            .collect(Collectors.toList());
        log.info("Save all objects employee.");
        this.employeeRepository.saveAll(listEmployeeSave);
        this.employeeRepository.flush();
        log.info("Saved successfully.");
        return true;
    }

}
