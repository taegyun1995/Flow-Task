package com.flow.task.fixedExtension.response;

import com.flow.task.fixedExtension.domain.FixedExtensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FixedExtensionResponse {

    private Long id;
    private String name;
    private String status;

    public FixedExtensionResponse(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public static FixedExtensionResponse create(FixedExtensions fixedExtensions) {
        return new FixedExtensionResponse(fixedExtensions.getId(), fixedExtensions.getExtensionName(), fixedExtensions.getStatus().name());
    }

}