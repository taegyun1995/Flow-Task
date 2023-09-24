package com.flow.task.fixedExtension.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "fixed_extensions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FixedExtensions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "extension_name", unique = true, nullable = false)
    private String extensionName;

    @Enumerated(EnumType.STRING)
    private ExtensionStatus status = ExtensionStatus.UNCHECK;

    public void fixedExtensionCheck() {
        this.status = ExtensionStatus.CHECK;
    }

    public void fixedExtensionUnCheck() {
        this.status = ExtensionStatus.UNCHECK;
    }

}