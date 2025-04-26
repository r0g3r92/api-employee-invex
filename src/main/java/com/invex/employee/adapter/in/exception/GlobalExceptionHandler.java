package com.invex.employee.adapter.in.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.invex.employee.adapter.out.persistence.exception.EmployeeNotFoundException;
import com.invex.employee.application.service.exception.EmployeeDataRequiredException;
import com.invex.employee.application.service.exception.EmployeeNotNullException;
import com.invex.employee.infrastructure.commons.dto.ErrorResponseDTO;
import com.invex.employee.infrastructure.commons.enums.CodeExceptionEnum;

/*
 *this component is by handle exception that the rest controller can be have 
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handler by catch only exceptions of type EmployeeDataRequiredException
     * @param ex
     * @return
     */
    @ExceptionHandler(EmployeeDataRequiredException.class)
    public ResponseEntity<ErrorResponseDTO> handleEmployeeDataRequiredException(EmployeeDataRequiredException ex){
        return new ResponseEntity<>(ErrorResponseDTO.builder()
        .code(CodeExceptionEnum.CODE_REQUIRED_EXCEPTION.getValue())
        .message(ex.getMessage())
        .build()
        ,HttpStatus.BAD_REQUEST
        );
    }

    /**
     * Handler by catch only exceptions of type EmployeeNotFoundException
     * @param ex
     * @return
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
        return new ResponseEntity<>(ErrorResponseDTO.builder()
        .code(CodeExceptionEnum.CODE_NOT_FOUND_EXCEPTION.getValue())
        .message(ex.getMessage())
        .build()
        ,HttpStatus.NOT_FOUND
        );
    }

    /**
     * Handler by catch only exceptions of type EmployeeNotNullException
     * @param ex
     * @return
     */
    @ExceptionHandler(EmployeeNotNullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEmployeeNotNullException(EmployeeNotNullException ex){
        return new ResponseEntity<>(ErrorResponseDTO.builder()
        .code(CodeExceptionEnum.CODE_REQUIRED_EXCEPTION.getValue())
        .message(ex.getMessage())
        .build()
        ,HttpStatus.NOT_FOUND
        );
    }

      /**
     * Handler by catch not valid argument
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handler by catch genera Exception that inherit from Exception
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleEmployeeGeneralException(Exception ex){
        return new ResponseEntity<>(ErrorResponseDTO.builder()
        .code(CodeExceptionEnum.CODE_GENERAL_EXCEPTION.getValue())
        .message(ex.getMessage())
        .build()
        ,HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

  

}
