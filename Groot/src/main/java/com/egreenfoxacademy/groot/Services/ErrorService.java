package com.egreenfoxacademy.groot.Services;

import com.egreenfoxacademy.groot.DTOs.ErrorDTO;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    public Object errorResponseGroot() {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("I am Groot!");

        return errorDTO;
    }

    public Object errorResponseYondu() {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("No parameter or invalid time");

        return errorDTO;
    }
}
