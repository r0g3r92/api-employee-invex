package com.invex.employee.domain.port.in.employee;

import java.util.List;
import com.invex.employee.domain.model.Employee;

public interface SearchEmployeeUseCase {

    List<Employee> getEmployees();
}
