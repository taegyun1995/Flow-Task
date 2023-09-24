package com.flow.task.fixedExtension.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FixedExtensionListResponse {

    private List<FixedExtensionResponse> responseList;

    public FixedExtensionListResponse(List<FixedExtensionResponse> responseList) {
        this.responseList = responseList;
    }

}