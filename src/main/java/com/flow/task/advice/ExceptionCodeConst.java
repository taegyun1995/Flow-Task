package com.flow.task.advice;

import lombok.Getter;

@Getter
public enum ExceptionCodeConst {

    NOT_FOUND_FIXED_EXTENSION(404, "NOT_FOUND_FIXED_EXTENSION", "고정 확장자를 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;

    ExceptionCodeConst(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}