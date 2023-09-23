package com.flow.task.controller;

import com.flow.task.response.UpdateFixedExtensionStatusResponse;
import com.flow.task.service.FixedExtensionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FixedExtensionController {

    private final FixedExtensionService fixedExtensionService;

    public FixedExtensionController(FixedExtensionService fixedExtensionService) {
        this.fixedExtensionService = fixedExtensionService;
    }

    @PutMapping("/fix/extension/{id}/check")
    public ResponseEntity<UpdateFixedExtensionStatusResponse> checkFixedExtension(@PathVariable Long id) {
        UpdateFixedExtensionStatusResponse response = fixedExtensionService.checkExtensionStatus(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/fix/extension/{id}/uncheck")
    public ResponseEntity<UpdateFixedExtensionStatusResponse> unCheckFixedExtension(@PathVariable Long id) {
        UpdateFixedExtensionStatusResponse response = fixedExtensionService.unCheckExtensionStatus(id);
        return ResponseEntity.ok(response);
    }

}