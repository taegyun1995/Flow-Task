package com.flow.task.domain;

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

    @Column(unique = true)
    private String extension;

    @Enumerated(EnumType.STRING)
    private ExtensionStatus status = ExtensionStatus.UNCHECK;

    public FixedExtensions(Long id, String extension, ExtensionStatus status) {
        this.id = id;
        this.extension = extension;
        this.status = status;
    }

    public void fixedExtensionCheck() {
        this.status = ExtensionStatus.CHECK;
    }

    public void fixedExtensionUnCheck() {
        this.status = ExtensionStatus.UNCHECK;
    }

}