package com.flow.task.fixedExtension.controller;

import com.flow.task.fixedExtension.response.FixedExtensionResponseList;
import com.flow.task.fixedExtension.response.UpdateFixedExtensionStatusResponse;
import com.flow.task.fixedExtension.service.FixedExtensionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FixedExtensionController {

    private final FixedExtensionService fixedExtensionService;

    public FixedExtensionController(FixedExtensionService fixedExtensionService) {
        this.fixedExtensionService = fixedExtensionService;
    }

    @PutMapping("/fixed/extension/{id}/check")
    public ResponseEntity<UpdateFixedExtensionStatusResponse> checkFixedExtension(@PathVariable Long id) {
        UpdateFixedExtensionStatusResponse response = fixedExtensionService.checkExtensionStatus(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/fixed/extension/{id}/uncheck")
    public ResponseEntity<UpdateFixedExtensionStatusResponse> unCheckFixedExtension(@PathVariable Long id) {
        UpdateFixedExtensionStatusResponse response = fixedExtensionService.unCheckExtensionStatus(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fixed/extensions")
    public ResponseEntity<FixedExtensionResponseList> getFixedExtensionList() {
        FixedExtensionResponseList response = fixedExtensionService.getFixedExtensionList();
        return ResponseEntity.ok(response);
    }

}