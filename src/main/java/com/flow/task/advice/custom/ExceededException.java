package com.flow.task.advice.custom;

import com.flow.task.advice.BusinessException;
import com.flow.task.advice.ExceptionCodeConst;

public class ExceededException extends BusinessException {

    public ExceededException(ExceptionCodeConst exceptionCodeConst) {
        super(exceptionCodeConst);
    }

}
