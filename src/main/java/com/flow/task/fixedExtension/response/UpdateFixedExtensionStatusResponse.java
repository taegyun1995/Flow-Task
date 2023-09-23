package com.flow.task.fixedExtension.response;

import lombok.Getter;

@Getter
public class UpdateFixedExtensionStatusResponse {

    private String FixedExtensionStatus;

    public UpdateFixedExtensionStatusResponse(String fixedExtensionStatus) {
        FixedExtensionStatus = fixedExtensionStatus;
    }

}