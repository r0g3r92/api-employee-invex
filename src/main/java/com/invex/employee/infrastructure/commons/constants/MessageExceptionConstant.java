package com.invex.employee.infrastructure.commons.constants;

public class MessageExceptionConstant {

    private MessageExceptionConstant(){
    }

    public static final String MESSAGE_EXCEPTION_EMPLOYEE_NOT_EXIST ="The employee to search doesn't exist try with other id again.";
    public static final String MESSAGE_EXCEPTION_NOT_EXIST_ROWS = "Not Exist employee rows.";
    public static final String MESSAGE_EXCEPTION_EMPLOYEE_ID_NULL ="For this action needs the employee id.";
    public static final String MESSAGE_EXCEPTION_EMPLOYEE_OBJECT_NULL ="The employee object should not be null, please check your request.";
    
}
