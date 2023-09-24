package com.flow.task.customExtension.response;

import com.flow.task.customExtension.domain.CustomExtensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtensionResponse {

    private Long id;
    private String name;

    public CustomExtensionResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CustomExtensionResponse create(CustomExtensions customExtensions) {
        return new CustomExtensionResponse(customExtensions.getId(), customExtensions.getExtensionName());
    }

}