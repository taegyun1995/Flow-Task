package com.flow.task.customExtension.service;

import com.flow.task.advice.ExceptionCodeConst;
import com.flow.task.advice.custom.AlreadyExistException;
import com.flow.task.advice.custom.ExceededException;
import com.flow.task.advice.custom.LengthRequiredException;
import com.flow.task.advice.custom.NotFoundException;
import com.flow.task.customExtension.domain.CustomExtensions;
import com.flow.task.customExtension.repository.CustomExtensionRepository;
import com.flow.task.customExtension.request.CreateCustomExtensionRequest;
import com.flow.task.customExtension.response.CreateCustomExtensionResponse;
import com.flow.task.customExtension.response.CustomExtensionResponse;
import com.flow.task.customExtension.response.CustomExtensionResponseList;
import com.flow.task.customExtension.response.DeleteCustomExtensionResponse;
import com.flow.task.fixedExtension.repository.FixedExtensionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.flow.task.advice.ExceptionCodeConst.ALREADY_FIXED_EXIST_EXTENSION;

@Service
@Transactional
public class CustomExtensionService {

    private static final int MAX_EXTENSION_NAME_LENGTH = 20;
    private static final int MAX_EXTENSION_COUNT = 200;

    private final FixedExtensionRepository fixedExtensionRepository;
    private final CustomExtensionRepository customExtensionRepository;

    public CustomExtensionService(FixedExtensionRepository fixedExtensionRepository, CustomExtensionRepository customExtensionRepository) {
        this.fixedExtensionRepository = fixedExtensionRepository;
        this.customExtensionRepository = customExtensionRepository;
    }

    public CreateCustomExtensionResponse addCustomExtension(CreateCustomExtensionRequest request) {
        existExtensionByName(request);
        validateExtensionNameLength(request);
        validateExtensionSize();
        validateIncludeFixedExtension(request);

        CustomExtensions customExtensions = CustomExtensions.create(request);
        customExtensionRepository.save(customExtensions);

        return new CreateCustomExtensionResponse(customExtensions.getExtensionName());
    }

    public DeleteCustomExtensionResponse deleteCustomExtension(Long extensionId) {
        CustomExtensions customExtensions = customExtensionRepository.findById(extensionId)
                .orElseThrow(() -> new NotFoundException(ExceptionCodeConst.NOT_FOUND_CUSTOM_EXTENSION));

        customExtensionRepository.delete(customExtensions);

        return new DeleteCustomExtensionResponse(customExtensions.getExtensionName());
    }

    public CustomExtensionResponseList getCustomExtensionList() {
        List<CustomExtensions> customExtensionsList = customExtensionRepository.findAll(Sort.by("id").ascending());
        List<CustomExtensionResponse> customExtensionResponseList = customExtensionsList.stream()
                .map(CustomExtensionResponse::create)
                .collect(Collectors.toList());

        return new CustomExtensionResponseList(customExtensionResponseList);
    }

    private void existExtensionByName(CreateCustomExtensionRequest request) {
        if (customExtensionRepository.existsByExtensionName(request.getExtensionName())) {
            throw new AlreadyExistException(ExceptionCodeConst.ALREADY_EXIST_EXTENSION);
        }
    }

    private void validateExtensionNameLength(CreateCustomExtensionRequest request) {
        if (request.getExtensionName().length() > MAX_EXTENSION_NAME_LENGTH) {
            throw new LengthRequiredException(ExceptionCodeConst.LENGTH_EXTENSION_NAME);
        }
    }

    private void validateExtensionSize() {
        if (customExtensionRepository.count() > MAX_EXTENSION_COUNT) {
            throw new ExceededException(ExceptionCodeConst.EXCEEDED_EXTENSION_LIMIT_200);
        }
    }

    private void validateIncludeFixedExtension(CreateCustomExtensionRequest request) {
        if (fixedExtensionRepository.existsByExtensionName(request.getExtensionName())) {
            throw new AlreadyExistException(ALREADY_FIXED_EXIST_EXTENSION);
        }
    }

}