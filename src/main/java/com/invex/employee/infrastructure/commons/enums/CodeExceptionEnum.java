package com.invex.employee.infrastructure.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeExceptionEnum {

    CODE_REQUIRED_EXCEPTION("REQUIRED_DATA_EXCEPTION"),
    CODE_NOT_FOUND_EXCEPTION("NOT_FOUND_EXCEPTION"),
    CODE_NOT_NULL_DATA_EXCEPTION("NOT_NULL_DATA_EXCEPTION"),
    CODE_GENERAL_EXCEPTION("INTERNAL_SERVER_ERROR");
    private String value;
}
