package com.invex.employee.application.service.exception;

public class EmployeeNotNullException extends RuntimeException{

    public EmployeeNotNullException(String message){
        super(message);
    }

    public EmployeeNotNullException(String message,Throwable cause){
        super(message, cause);
    }
}
