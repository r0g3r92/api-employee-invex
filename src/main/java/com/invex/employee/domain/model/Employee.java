package com.invex.employee.domain.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Entity that represent an employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Schema(description = "Employee id",example = "1")
    private Long idEmployee;

    @Schema(description = "First name of employee",example = "Rogelio", defaultValue = "Rogelio")
    @NotBlank(message = "The field firstName is obligatory.")
    private String firstName;

    @Schema(description = "Second name of employee can be null",example = "Pedro", defaultValue = "")
    private String secondName;

    @Schema(description = "paternal surname of employee",example = "Lopez" ,defaultValue = "Lopez")
    @NotBlank(message = "The field paternalSurname is obligatory.")
    private String paternalSurname;

    @Schema(description = "Maternal surname of Employee",example = "Gomez", defaultValue = "Gomez")
    private String maternalSurname;

    @Schema(description = "Age of employee",example = "32", defaultValue = "32")
    @NotNull(message = "The field age is obligatory.")
    private Integer age;

    @Schema(description = "Gender of employee",example = "Male/Female",defaultValue = "Male")
    @NotBlank(message = "The field gender is obligatory.")
    private String gender;

    @Schema(description = "Birth date of employee, this field have a format 'yyyy-MM-dd'",example = "1992-11-07", defaultValue = "1992-11-07")
    @NotNull(message = "The field birthDate is obligatory.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date birthDate;

    @Schema(description = "Title job of employee",example = "Developer", defaultValue = "Developer")
    private String titleJob;
}
