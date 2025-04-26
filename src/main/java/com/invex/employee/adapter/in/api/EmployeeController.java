package com.invex.employee.adapter.in.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invex.employee.application.service.employee.CreateEmployeeService;
import com.invex.employee.application.service.employee.DeleteEmployeeService;
import com.invex.employee.application.service.employee.SearchEmployeeService;
import com.invex.employee.application.service.employee.UpdateEmployeeService;
import com.invex.employee.domain.model.Employee;
import com.invex.employee.infrastructure.commons.dto.ErrorResponseDTO;
import com.invex.employee.infrastructure.commons.dto.ResponseDTO;
import com.invex.employee.infrastructure.commons.enums.CodeResponseEnum;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_CREATE_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_DELETE_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_SEARCH_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.API_UPDATE_EMPLOYEE;
import static com.invex.employee.infrastructure.commons.constants.ApiConstant.VERSION_API;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * This controller does the crud actions of employee
 */
@Tag(name = "Employee", description = "This collection of API's was build by manage Employees")
@RestController
@RequestMapping(VERSION_API)
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {


    private final CreateEmployeeService createService;
    private final DeleteEmployeeService deleteService;
    private final SearchEmployeeService searchService;
    private final UpdateEmployeeService updateService;

    /**
     * API_CREATE_EMPLOYEE
     * This api creates new employee or employees 
     * @param employeeList
     * @return
     */
    @Operation(summary = "This api creates new employee or employees")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Employees were created", 
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ResponseDTO.class))),
        @ApiResponse(responseCode = "500", description = "Was occurred and error Internal_Server_Error", 
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping(API_CREATE_EMPLOYEE)
    public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody List<Employee> employeeList){
        this.createService.createEmployee(employeeList);
        return new ResponseEntity<>(ResponseDTO.builder()
            .code(CodeResponseEnum.SUCCESS.getCode())
            .message(CodeResponseEnum.SUCCESS.name())
            .build()
            ,HttpStatus.CREATED);
             
    }

    /**
     * API_DELETE_EMPLOYEE
     * This api deletes an employee by employee ID 
     * @param idEmployee
     * @return
     */
    @Operation(summary = "This api deletes an employee by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employees were created", 
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ResponseDTO.class))),
        @ApiResponse(responseCode = "500", description = "Was occurred and error Internal_Server_Error",
                 content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Was occurred and error Bad_Request", 
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Was occurred and error Not_Found", 
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @DeleteMapping(API_DELETE_EMPLOYEE)
    public ResponseEntity<ResponseDTO> deleteEmployee(
        @Parameter(description = "Employee Id",example = "1") @PathVariable Long id){

        this.deleteService.deleteEmployee(id);
        return ResponseEntity.ok(ResponseDTO.builder()
                    .code(CodeResponseEnum.SUCCESS.getCode())
                    .message(CodeResponseEnum.SUCCESS.name())
                    .build());
        
    }

    /**
     * API_SEARCH_EMPLOYEE
     * This api returns all employees that were created 
     * @return
     */
    @Operation(summary = "This api return all employees that were created.")
    @ApiResponse(responseCode = "200", description = "Get list of employees that were created", 
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = Employee.class)))
    @GetMapping(API_SEARCH_EMPLOYEE)
    public ResponseEntity<List<Employee>> searchAllEmployees(){
        return ResponseEntity.ok(this.searchService.getEmployees());
    }

    /**
     * API_UPDATE_EMPLOYEE
     * This api update employee information that we need to change, it's necessary her employee ID 
     * @param employee
     * @return
     */
    @Operation(summary = "This api update employee information that we need to change, it's necessary her employee ID ")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Update personal information of employees ", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ResponseDTO.class))),
@ApiResponse(responseCode = "500", description = "Was occurred and error Internal_Server_Error",
         content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponseDTO.class))),
@ApiResponse(responseCode = "400", description = "Was occurred and error Bad_Request", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponseDTO.class))),
@ApiResponse(responseCode = "404", description = "Was occurred and error Not_Found", 
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PutMapping(API_UPDATE_EMPLOYEE)
    public ResponseEntity<ResponseDTO> updateEmploye(@Valid @RequestBody Employee employee){

        this.updateService.updateEmployee(employee);
        return ResponseEntity.ok(ResponseDTO.builder()
                .code(CodeResponseEnum.SUCCESS.getCode())
                .message(CodeResponseEnum.SUCCESS.name())
                .build());
    }
}
