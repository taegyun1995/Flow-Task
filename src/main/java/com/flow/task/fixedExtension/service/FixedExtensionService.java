package com.flow.task.fixedExtension.service;

import com.flow.task.advice.custom.NotFoundException;
import com.flow.task.fixedExtension.domain.ExtensionStatus;
import com.flow.task.fixedExtension.domain.FixedExtensions;
import com.flow.task.fixedExtension.repository.FixedExtensionRepository;
import com.flow.task.fixedExtension.response.FixedExtensionListResponse;
import com.flow.task.fixedExtension.response.FixedExtensionResponse;
import com.flow.task.fixedExtension.response.UpdateFixedExtensionStatusResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.flow.task.advice.ExceptionCodeConst.NOT_FOUND_FIXED_EXTENSION;

@Service
@Transactional
public class FixedExtensionService {

    private final FixedExtensionRepository fixedExtensionRepository;

    public FixedExtensionService(FixedExtensionRepository fixedExtensionRepository) {
        this.fixedExtensionRepository = fixedExtensionRepository;
    }

    public UpdateFixedExtensionStatusResponse checkExtensionStatus(Long extensionId) {
        FixedExtensions fixedExtensions = fixedExtensionRepository.findByIdAndStatus(extensionId, ExtensionStatus.UNCHECK)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_FIXED_EXTENSION));

        fixedExtensions.fixedExtensionCheck();

        return new UpdateFixedExtensionStatusResponse(fixedExtensions.getStatus().name());
    }

    public UpdateFixedExtensionStatusResponse unCheckExtensionStatus(Long extensionId) {
        FixedExtensions fixedExtensions = fixedExtensionRepository.findByIdAndStatus(extensionId, ExtensionStatus.CHECK)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_FIXED_EXTENSION));

        fixedExtensions.fixedExtensionUnCheck();

        return new UpdateFixedExtensionStatusResponse(fixedExtensions.getStatus().name());
    }

    public FixedExtensionListResponse getFixedExtensionList() {
        List<FixedExtensions> fixedExtensionsList = fixedExtensionRepository.findAll();
        List<FixedExtensionResponse> fixedExtensionResponseList = fixedExtensionsList.stream()
                .map(FixedExtensionResponse::create)
                .collect(Collectors.toList());

        return new FixedExtensionListResponse(fixedExtensionResponseList);
    }

}