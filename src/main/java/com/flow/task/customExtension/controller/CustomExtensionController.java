package com.flow.task.customExtension.controller;

import com.flow.task.customExtension.request.CreateCustomExtensionRequest;
import com.flow.task.customExtension.response.CreateCustomExtensionResponse;
import com.flow.task.customExtension.service.CustomExtensionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomExtensionController {

    private final CustomExtensionService customExtensionService;

    public CustomExtensionController(CustomExtensionService customExtensionService) {
        this.customExtensionService = customExtensionService;
    }

    @PostMapping("/custom/extension")
    public ResponseEntity<CreateCustomExtensionResponse> addCustomExtension(@RequestBody CreateCustomExtensionRequest request) {
        CreateCustomExtensionResponse response = customExtensionService.addCustomExtension(request);
        return ResponseEntity.ok(response);
    }

}