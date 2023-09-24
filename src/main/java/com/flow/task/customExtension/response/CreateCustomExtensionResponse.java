package com.flow.task.customExtension.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateCustomExtensionResponse {

    private String CustomExtensionName;

    public CreateCustomExtensionResponse(String customExtensionName) {
        CustomExtensionName = customExtensionName;
    }

}