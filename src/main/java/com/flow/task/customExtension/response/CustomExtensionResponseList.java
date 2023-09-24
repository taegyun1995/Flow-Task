package com.flow.task.customExtension.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtensionResponseList {

    private List<CustomExtensionResponse> responseList;

    public CustomExtensionResponseList(List<CustomExtensionResponse> responseList) {
        this.responseList = responseList;
    }

}