package com.flow.task.customExtension.controller;

import com.flow.task.customExtension.request.CreateCustomExtensionRequest;
import com.flow.task.customExtension.response.CreateCustomExtensionResponse;
import com.flow.task.customExtension.response.DeleteCustomExtensionResponse;
import com.flow.task.customExtension.service.CustomExtensionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/custom/extension/{id}/delete")
    public ResponseEntity<DeleteCustomExtensionResponse> deleteCustomExtension(@PathVariable Long id) {
        DeleteCustomExtensionResponse response = customExtensionService.deleteCustomExtension(id);
        return ResponseEntity.ok(response);
    }

}