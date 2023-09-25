package com.flow.task.customExtension.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtensionResponseList {

    private int currentExtensionSize;
    private List<CustomExtensionResponse> responseList;

    public CustomExtensionResponseList(int currentExtensionSize, List<CustomExtensionResponse> responseList) {
        this.currentExtensionSize = currentExtensionSize;
        this.responseList = responseList;
    }

}