package com.invex.employee.domain.port.out.employee;

import java.util.List;

import com.invex.employee.domain.model.Employee;

public interface SearchEmployeeRepositoryPort {

    List<Employee> getEmployees();
}
