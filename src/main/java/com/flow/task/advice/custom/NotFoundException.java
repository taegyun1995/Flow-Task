package com.flow.task.advice.custom;

import com.flow.task.advice.BusinessException;
import com.flow.task.advice.ExceptionCodeConst;

public class NotFoundException extends BusinessException {

    public NotFoundException(ExceptionCodeConst exceptionCodeConst) {
        super(exceptionCodeConst);
    }

}