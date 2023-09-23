package com.flow.task.advice;

import lombok.Getter;

@Getter
public class ExceptionResponse {

    private int status;
    private String code;
    private String message;

    public ExceptionResponse(ExceptionCodeConst exceptionCodeConst) {
        this.status = exceptionCodeConst.getStatus();
        this.code = exceptionCodeConst.getCode();
        this.message = exceptionCodeConst.getMessage();
    }

}