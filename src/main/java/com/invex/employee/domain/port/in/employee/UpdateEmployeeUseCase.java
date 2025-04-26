package com.invex.employee.domain.port.in.employee;

import com.invex.employee.domain.model.Employee;

public interface UpdateEmployeeUseCase {

    boolean updateEmployee(Employee employeeUpdate);
}
