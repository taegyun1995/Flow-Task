package com.flow.task.customExtension.domain;

import com.flow.task.customExtension.request.CreateCustomExtensionRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "custom_extensions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtensions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "extension_name", unique = true, length = 20, nullable = false)
    private String extensionName;

    public CustomExtensions(String extensionName) {
        this.extensionName = extensionName;
    }

    public static CustomExtensions create(CreateCustomExtensionRequest request) {
        return new CustomExtensions(request.getExtensionName());
    }

}