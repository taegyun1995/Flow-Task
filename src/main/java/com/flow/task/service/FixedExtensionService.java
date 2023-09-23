package com.flow.task.service;

import com.flow.task.advice.custom.NotFoundException;
import com.flow.task.domain.ExtensionStatus;
import com.flow.task.domain.FixedExtensions;
import com.flow.task.repository.FixedExtensionRepository;
import com.flow.task.response.UpdateFixedExtensionStatusResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.flow.task.advice.ExceptionCodeConst.NOT_FOUND_FIXED_EXTENSION;

@Service
public class FixedExtensionService {

    private final FixedExtensionRepository fixedExtensionRepository;

    public FixedExtensionService(FixedExtensionRepository fixedExtensionRepository) {
        this.fixedExtensionRepository = fixedExtensionRepository;
    }

    @Transactional
    public UpdateFixedExtensionStatusResponse updateExtensionStatus(Long extensionId) {
        FixedExtensions fixedExtensions = fixedExtensionRepository.findByIdAndStatus(extensionId, ExtensionStatus.UNCHECK)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_FIXED_EXTENSION));

        fixedExtensions.fixedExtensionCheck();

        return new UpdateFixedExtensionStatusResponse(fixedExtensions.getStatus().name());
    }

}