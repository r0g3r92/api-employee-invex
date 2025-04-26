package com.invex.employee.application.service.employee;

import static com.invex.employee.infrastructure.commons.constants.MessageExceptionConstant.MESSAGE_EXCEPTION_EMPLOYEE_ID_NULL;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.invex.employee.application.service.exception.EmployeeDataRequiredException;
import com.invex.employee.domain.port.in.employee.DeleteEmployeeUseCase;
import com.invex.employee.domain.port.out.employee.DeleteEmployeeRepositoryPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteEmployeeService implements DeleteEmployeeUseCase {

    private final DeleteEmployeeRepositoryPort deleteEmployeePort;
    @Override
    public boolean deleteEmployee(Long idEmployee) {
        if(Objects.isNull(idEmployee)){
            throw new EmployeeDataRequiredException(MESSAGE_EXCEPTION_EMPLOYEE_ID_NULL);
        }
        log.info("Execute service to delete employee with id:{}",idEmployee);
        return this.deleteEmployeePort.deleteEmployee(idEmployee);
    }

}
