package com.flow.task.advice;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ExceptionCodeConst exceptionCodeConst;

    public BusinessException(ExceptionCodeConst exceptionCodeConst) {
        super(exceptionCodeConst.getMessage());
        this.exceptionCodeConst = exceptionCodeConst;
    }

}