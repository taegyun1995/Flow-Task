package com.flow.task.fixedExtension.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FixedExtensionResponseList {

    private List<FixedExtensionResponse> responseList;

    public FixedExtensionResponseList(List<FixedExtensionResponse> responseList) {
        this.responseList = responseList;
    }

}