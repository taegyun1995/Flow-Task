package com.flow.task.advice;

import lombok.Getter;

@Getter
public enum ExceptionCodeConst {

    NOT_FOUND_FIXED_EXTENSION(404, "NOT_FOUND_FIXED_EXTENSION", "고정 확장자를 찾을 수 없습니다."),
    NOT_FOUND_CUSTOM_EXTENSION(404, "NOT_FOUND_CUSTOM_EXTENSION", "커스텀 확장자를 찾을 수 없습니다."),

    ALREADY_FIXED_EXIST_EXTENSION(409, "ALREADY_FIXED_EXIST_EXTENSION", "이미 고정 확장자로 등록되었습니다."),
    ALREADY_EXIST_EXTENSION(409, "ALREADY_EXIST_EXTENSION", "이미 등록된 확장자입니다."),

    LENGTH_EXTENSION_NAME(416, "LENGTH_EXTENSION_NAME", "확장자의 길이를 20글자 이하로 작성해주세요."),
    EXCEEDED_EXTENSION_LIMIT_200(416, "EXCEEDED_EXTENSION_LIMIT_200", "등록할 수 있는 확장자의 개수가 200개를 초과할 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;

    ExceptionCodeConst(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}