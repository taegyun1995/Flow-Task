package com.flow.task.customExtension.response;

import lombok.Getter;

@Getter
public class CreateCustomExtensionResponse {

    private String CustomExtensionName;

    public CreateCustomExtensionResponse(String customExtensionName) {
        CustomExtensionName = customExtensionName;
    }

}