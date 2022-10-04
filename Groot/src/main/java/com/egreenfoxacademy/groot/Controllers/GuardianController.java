package com.egreenfoxacademy.groot.Controllers;

import com.egreenfoxacademy.groot.DTOs.ErrorDTO;
import com.egreenfoxacademy.groot.DTOs.ReceivedGrootDTO;
import com.egreenfoxacademy.groot.DTOs.ReceivedYonduDTO;
import com.egreenfoxacademy.groot.DTOs.ResponseGrootDTO;
import com.egreenfoxacademy.groot.Services.ErrorService;
import com.egreenfoxacademy.groot.Services.GrootService;
import com.egreenfoxacademy.groot.Services.GrootServiceImpl;
import com.egreenfoxacademy.groot.Services.YonduServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

    GrootServiceImpl grootServiceImpl;

    YonduServiceImpl yonduServiceImpl;

    ErrorService errorService;

    @Autowired
    public GuardianController(GrootServiceImpl grootServiceImpl, YonduServiceImpl yonduServiceImpl, ErrorService errorService) {
        this.grootServiceImpl = grootServiceImpl;
        this.yonduServiceImpl = yonduServiceImpl;
        this.errorService = errorService;
    }

    @GetMapping("/groot")
    public ResponseEntity<Object> renderResponseGroot(@RequestBody(required = false) ReceivedGrootDTO receivedGrootDTO) {

        if (receivedGrootDTO.getMessage() == null) {
            return ResponseEntity.status(404).body(errorService.errorResponseGroot());
        } else {
            return ResponseEntity.ok(grootServiceImpl.response(receivedGrootDTO));
        }
        }



    @GetMapping("/yondu")
    public ResponseEntity<Object> renderResponseYondu(@RequestBody (required = false) ReceivedYonduDTO receivedYonduDTO) {

        if (receivedYonduDTO == null || receivedYonduDTO.getDistance() == null || receivedYonduDTO.getTime() == null || receivedYonduDTO.getTime() <= 0) {
            return ResponseEntity.status(404).body(errorService.errorResponseYondu());
        } else {
            return ResponseEntity.ok(yonduServiceImpl.response(receivedYonduDTO));
        }

    }

}


