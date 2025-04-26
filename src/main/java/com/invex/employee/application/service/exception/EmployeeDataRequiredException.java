package com.invex.employee.application.service.exception;


public class EmployeeDataRequiredException extends RuntimeException{

    public EmployeeDataRequiredException(String message){
        super(message);
    }
    public EmployeeDataRequiredException(String message, Throwable cause){
        super(message, cause);
    }
}
