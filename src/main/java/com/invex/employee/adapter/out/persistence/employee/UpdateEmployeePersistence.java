package com.invex.employee.adapter.out.persistence.employee;

import java.util.Optional;
import static com.invex.employee.infrastructure.commons.constants.MessageExceptionConstant.MESSAGE_EXCEPTION_EMPLOYEE_NOT_EXIST;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.invex.employee.application.service.exception.EmployeeDataRequiredException;
import com.invex.employee.domain.model.Employee;
import com.invex.employee.domain.port.out.employee.UpdateEmployeeRepositoryPort;
import com.invex.employee.infrastructure.dao.entity.EmployeeEntity;
import com.invex.employee.infrastructure.dao.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateEmployeePersistence implements UpdateEmployeeRepositoryPort{

    private final EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public boolean updateEmployee(Employee employeeUpdate) {
      
        log.info("find employee by id");
        Optional<EmployeeEntity> employeeOptional = this.employeeRepository.findById(employeeUpdate.getIdEmployee());
        if(!employeeOptional.isPresent()){
            log.info("Doesn't exist employee for update");
            throw new EmployeeDataRequiredException(MESSAGE_EXCEPTION_EMPLOYEE_NOT_EXIST);
        }

        log.info("Change information of employee");
        EmployeeEntity employeeEntity = employeeOptional.get();
        employeeEntity.setAge(employeeUpdate.getAge());
        employeeEntity.setBirthDate(employeeUpdate.getBirthDate());
        employeeEntity.setFirstName(employeeUpdate.getFirstName());
        employeeEntity.setGender(employeeUpdate.getGender());
        employeeEntity.setMaternalSurname(employeeUpdate.getMaternalSurname());
        employeeEntity.setPaternalSurname(employeeUpdate.getPaternalSurname());
        employeeEntity.setSecondName(employeeUpdate.getSecondName());
        employeeEntity.setTitleJob(employeeUpdate.getTitleJob());
        

        log.info("Save changes");
        this.employeeRepository.save(employeeEntity);
        log.info("Updated successfully");
        return true;
    }

}
