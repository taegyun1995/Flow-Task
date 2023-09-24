package com.flow.task.advice.custom;

import com.flow.task.advice.BusinessException;
import com.flow.task.advice.ExceptionCodeConst;

public class AlreadyExistException extends BusinessException {

    public AlreadyExistException(ExceptionCodeConst exceptionCodeConst) {
        super(exceptionCodeConst);
    }

}