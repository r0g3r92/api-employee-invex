package com.invex.employee.adapter.out.persistence.employee;

import java.util.Optional;

import static com.invex.employee.infrastructure.commons.constants.MessageExceptionConstant.MESSAGE_EXCEPTION_EMPLOYEE_NOT_EXIST;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.invex.employee.adapter.out.persistence.exception.EmployeeNotFoundException;
import com.invex.employee.domain.port.out.employee.DeleteEmployeeRepositoryPort;

import com.invex.employee.infrastructure.dao.entity.EmployeeEntity;
import com.invex.employee.infrastructure.dao.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class DeleteEmployeePersistence implements DeleteEmployeeRepositoryPort{

    private final EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public boolean deleteEmployee(Long idEmployee) {
        log.info("find employee by ID.");
        Optional<EmployeeEntity> optionalEmployee = this.employeeRepository.findById(idEmployee);
        
        if(!optionalEmployee.isPresent()){
            log.info("Employee doesn't exist.");
            throw new EmployeeNotFoundException(MESSAGE_EXCEPTION_EMPLOYEE_NOT_EXIST);
        }
        log.info("Delete employee.");
        this.employeeRepository.delete(optionalEmployee.get());
        log.info("Deleted successfully");
        return true;
    }

}
