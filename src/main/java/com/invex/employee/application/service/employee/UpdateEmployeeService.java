package com.invex.employee.application.service.employee;

import static com.invex.employee.infrastructure.commons.constants.MessageExceptionConstant.MESSAGE_EXCEPTION_EMPLOYEE_ID_NULL;
import static com.invex.employee.infrastructure.commons.constants.MessageExceptionConstant.MESSAGE_EXCEPTION_EMPLOYEE_OBJECT_NULL;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.invex.employee.application.service.exception.EmployeeDataRequiredException;
import com.invex.employee.application.service.exception.EmployeeNotNullException;
import com.invex.employee.domain.model.Employee;
import com.invex.employee.domain.port.in.employee.UpdateEmployeeUseCase;
import com.invex.employee.domain.port.out.employee.UpdateEmployeeRepositoryPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateEmployeeService implements UpdateEmployeeUseCase{

    private final UpdateEmployeeRepositoryPort updateEmployeePort;
    @Override
    public boolean updateEmployee(Employee employeeUpdate) {
        log.info("Execute service to update employee.");
        log.info("Validate if employee object isn't null.");
        if(Objects.isNull(employeeUpdate)){
            throw new EmployeeNotNullException(MESSAGE_EXCEPTION_EMPLOYEE_OBJECT_NULL);
        }

        log.info("Validate if employee id isn't null.");
        if(Objects.isNull(employeeUpdate.getIdEmployee())){
            throw new EmployeeDataRequiredException(MESSAGE_EXCEPTION_EMPLOYEE_ID_NULL);
        }
        return this.updateEmployeePort.updateEmployee(employeeUpdate);
    }

}
