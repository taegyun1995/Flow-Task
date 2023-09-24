package com.flow.task.fixedExtension.repository;

import com.flow.task.fixedExtension.domain.ExtensionStatus;
import com.flow.task.fixedExtension.domain.FixedExtensions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FixedExtensionRepository extends JpaRepository<FixedExtensions, Long> {

    Optional<FixedExtensions> findByIdAndStatus(Long id, ExtensionStatus status);

}