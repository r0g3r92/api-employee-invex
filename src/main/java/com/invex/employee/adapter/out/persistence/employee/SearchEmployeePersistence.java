package com.invex.employee.adapter.out.persistence.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import static com.invex.employee.infrastructure.commons.constants.MessageExceptionConstant.MESSAGE_EXCEPTION_NOT_EXIST_ROWS;

import com.invex.employee.adapter.out.persistence.exception.EmployeeNotFoundException;
import com.invex.employee.domain.model.Employee;
import com.invex.employee.domain.port.out.employee.SearchEmployeeRepositoryPort;
import com.invex.employee.infrastructure.dao.entity.EmployeeEntity;
import com.invex.employee.infrastructure.dao.repository.EmployeeRepository;
import com.invex.employee.infrastructure.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class SearchEmployeePersistence implements SearchEmployeeRepositoryPort{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees() {
        log.info("Find all Employees");
        List<EmployeeEntity> listEmployeeEntity =this.employeeRepository.findAll();
        if(listEmployeeEntity.isEmpty()){
            log.info("Not exist any employee in the data base.");
            throw new EmployeeNotFoundException(MESSAGE_EXCEPTION_NOT_EXIST_ROWS);
        }
        log.info("Convert Objects");
        List<Employee> listEmployeeResponse = listEmployeeEntity.stream()
                    .map(this.employeeMapper::convertToEmployee)
                    .collect(Collectors.toList());
        return listEmployeeResponse;
    }

}
