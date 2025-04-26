package com.invex.employee.application.service.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invex.employee.domain.model.Employee;
import com.invex.employee.domain.port.in.employee.CreateEmployeeUseCase;
import com.invex.employee.domain.port.out.employee.CreateEmployeeRepositoryPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateEmployeeService implements CreateEmployeeUseCase{

    private final CreateEmployeeRepositoryPort createEmployeePort;

    @Override
    public boolean createEmployee(List<Employee> listEmployee) {
        log.info("Execute employee service to save employee list.");
        return this.createEmployeePort.createEmployee(listEmployee);
    }

}
