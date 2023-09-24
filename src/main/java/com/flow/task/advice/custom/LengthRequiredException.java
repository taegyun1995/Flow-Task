package com.flow.task.advice.custom;

import com.flow.task.advice.BusinessException;
import com.flow.task.advice.ExceptionCodeConst;

public class LengthRequiredException extends BusinessException {

    public LengthRequiredException(ExceptionCodeConst exceptionCodeConst) {
        super(exceptionCodeConst);
    }

}