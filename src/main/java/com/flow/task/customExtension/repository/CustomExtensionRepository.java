package com.flow.task.customExtension.repository;

import com.flow.task.customExtension.domain.CustomExtensions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomExtensionRepository extends JpaRepository<CustomExtensions, Long> {

    Boolean existsByExtensionName(String extensionName);

}