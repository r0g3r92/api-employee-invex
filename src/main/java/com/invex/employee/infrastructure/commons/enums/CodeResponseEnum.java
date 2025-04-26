package com.invex.employee.infrastructure.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeResponseEnum {

    SUCCESS(0),
    ERROR_SAVED(-1);
    private Integer code;
}
