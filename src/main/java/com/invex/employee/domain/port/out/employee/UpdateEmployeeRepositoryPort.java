package com.invex.employee.domain.port.out.employee;

import com.invex.employee.domain.model.Employee;

public interface UpdateEmployeeRepositoryPort {

    boolean updateEmployee(Employee employeeUpdate);
}
