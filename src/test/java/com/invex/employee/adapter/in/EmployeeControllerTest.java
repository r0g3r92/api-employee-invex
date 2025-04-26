package com.invex.employee.adapter.in;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_CREATE_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_DELETE_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_SEARCH_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_UPDATE_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.VERSION_API;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invex.employee.adapter.in.api.EmployeeController;
import com.invex.employee.adapter.out.persistence.exception.EmployeeNotFoundException;
import com.invex.employee.application.service.employee.CreateEmployeeService;
import com.invex.employee.application.service.employee.DeleteEmployeeService;
import com.invex.employee.application.service.employee.SearchEmployeeService;
import com.invex.employee.application.service.employee.UpdateEmployeeService;
import com.invex.employee.application.service.exception.EmployeeDataRequiredException;
import com.invex.employee.domain.model.Employee;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @MockBean
    private CreateEmployeeService createService;
    @MockBean
    private DeleteEmployeeService deleteService;
    @MockBean
    private SearchEmployeeService searchService;
    @MockBean
    private UpdateEmployeeService updateService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployeeSuccessTest() throws Exception{
        when(this.createService.createEmployee(any()))
        .thenReturn(true);
        List<Employee> employeeList =new ArrayList<>();
        employeeList.add(buildEmployeeTest());

        mockMvc.perform(post(VERSION_API+API_CREATE_EMPLOYEE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(employeeList))            
            )
            .andExpect(status().isCreated());
    }
    @Test
    public void createEmployeeInternalServerErrorTest() throws Exception{
        when(this.createService.createEmployee(any()))
        .thenReturn(true);
        

        mockMvc.perform(post(VERSION_API+API_CREATE_EMPLOYEE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(buildEmployeeTest()))            
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    public void deleteEmployeeSuccessTest() throws Exception{
        when(this.deleteService.deleteEmployee(anyLong()))
        .thenReturn(true);
        

        mockMvc.perform(delete(VERSION_API+"/delete/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE)        
            )
            .andExpect(status().isOk());
    }

    @Test
    public void deleteEmployeeInternalServerErrorTest() throws Exception{
        when(this.deleteService.deleteEmployee(anyLong()))
        .thenThrow(IllegalStateException.class);
        

        mockMvc.perform(delete(VERSION_API+"/delete/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE)        
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    public void deleteEmployeeBadRequestTest() throws Exception{
        when(this.deleteService.deleteEmployee(anyLong()))
        .thenThrow(EmployeeDataRequiredException.class);
        

        mockMvc.perform(delete(VERSION_API+"/delete/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE)        
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteEmployeeNotFoundTest() throws Exception{
        when(this.deleteService.deleteEmployee(anyLong()))
        .thenThrow(EmployeeNotFoundException.class);
        

        mockMvc.perform(delete(VERSION_API+"/delete/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE)        
            )
            .andExpect(status().isNotFound());
    }


    @Test
    public void searchAllEmployeeSuccessTest() throws Exception{
        List<Employee> listEmployee = new ArrayList<>();
        listEmployee.add(this.buildEmployeeTest());

        when(this.searchService.getEmployees())
        .thenReturn(listEmployee);
        

        mockMvc.perform(get(VERSION_API+API_SEARCH_EMPLOYEE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)        
            )
            .andExpect(status().isOk());
    }

    @Test
    public void searchAllEmployeeInternalServerErrorTest() throws Exception{
        when(this.searchService.getEmployees())
        .thenThrow(IllegalStateException.class);
        

        mockMvc.perform(get(VERSION_API+API_SEARCH_EMPLOYEE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)        
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    public void updateEmployeeSuccessTest() throws Exception{
        when(this.updateService.updateEmployee(any()))
        .thenReturn(true);
        

        mockMvc.perform(put(VERSION_API+API_UPDATE_EMPLOYEE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(this.buildEmployeeTest()))  
            )
            .andExpect(status().isOk());
    }

    @Test
    public void UpdateEmployeeInternalServerErrorTest() throws Exception{
        when(this.updateService.updateEmployee(any()))
        .thenThrow(IllegalStateException.class);
        

        mockMvc.perform(put(VERSION_API+API_UPDATE_EMPLOYEE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(this.buildEmployeeTest()))  
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    public void updateEmployeeBadRequestTest() throws Exception{
        when(this.updateService.updateEmployee(any()))
        .thenThrow(EmployeeDataRequiredException.class);
        

        mockMvc.perform(put(VERSION_API+API_UPDATE_EMPLOYEE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(this.buildEmployeeTest()))  
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    public void updateEmployeeNotFoundTest() throws Exception{
        when(this.updateService.updateEmployee(any()))
        .thenThrow(EmployeeNotFoundException.class);
        

        mockMvc.perform(put(VERSION_API+API_UPDATE_EMPLOYEE)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(objectMapper.writeValueAsString(this.buildEmployeeTest()))  
        )
            .andExpect(status().isNotFound());
    }

    private Employee buildEmployeeTest(){
        Employee employee = Employee.builder()
        .age(24)
        .birthDate(new Date())
        .firstName("Rogelio")
        .gender("Male")
        .paternalSurname("Lopez")
        .maternalSurname("Gomez")
        .titleJob("Develop")
        .build(); 
        return employee;
    }
}
