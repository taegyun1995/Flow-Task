package com.flow.task.customExtension.response;

import lombok.Getter;

@Getter
public class DeleteCustomExtensionResponse {

    private String CustomExtensionName;

    public DeleteCustomExtensionResponse(String customExtensionName) {
        CustomExtensionName = customExtensionName;
    }

}