package com.invex.employee.infrastructure.commons.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Entity notifying of any error that occurred during the process")
@Data
@Builder
public class ErrorResponseDTO {

    @Schema(description = "Code is the field by notify the error code", example = "REQUIRED_DATA_EXCEPTION")
    private String code;
    @Schema(description = "Message is the field by notify the message error", example = "For this action needs the employee id.")
    private String message;
}
