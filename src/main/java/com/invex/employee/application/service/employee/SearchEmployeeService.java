package com.invex.employee.application.service.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invex.employee.domain.model.Employee;
import com.invex.employee.domain.port.in.employee.SearchEmployeeUseCase;
import com.invex.employee.domain.port.out.employee.SearchEmployeeRepositoryPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchEmployeeService implements SearchEmployeeUseCase {

    private final SearchEmployeeRepositoryPort searchEmployeePort;
    
    @Override
    public List<Employee> getEmployees() {
        log.info("Execute service to search all employees that was saved.");
        return this.searchEmployeePort.getEmployees();
    }

}
