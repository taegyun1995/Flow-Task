package com.flow.task.customExtension.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeleteCustomExtensionResponse {

    private String CustomExtensionName;

    public DeleteCustomExtensionResponse(String customExtensionName) {
        CustomExtensionName = customExtensionName;
    }

}