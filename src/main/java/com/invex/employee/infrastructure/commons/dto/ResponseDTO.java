package com.invex.employee.infrastructure.commons.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Entity DTO by create a response of request")
@Data
@Builder
public class ResponseDTO {

    @Schema(description = "Code is the field by notify the operation code", example = "0/1",defaultValue = "0")
    private Integer code;
    @Schema(description = "Message is the field by notify the message code", example = "SUCCESS/ERROR_SAVED", defaultValue = "SUCCESS")
    private String message;
}
