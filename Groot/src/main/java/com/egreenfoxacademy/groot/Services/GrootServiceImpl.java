package com.egreenfoxacademy.groot.Services;

import com.egreenfoxacademy.groot.DTOs.ErrorDTO;
import com.egreenfoxacademy.groot.DTOs.ReceivedGrootDTO;
import com.egreenfoxacademy.groot.DTOs.ResponseGrootDTO;
import org.springframework.stereotype.Service;

@Service
public class GrootServiceImpl implements GrootService{
    @Override
    public Object response(ReceivedGrootDTO receivedGrootDTO) {

        if(receivedGrootDTO == null) {
            ErrorDTO errorDTO = new ErrorDTO();

            errorDTO.setError("I am Groot!");

            return errorDTO;

        } else {
            ResponseGrootDTO responseGrootDTO = new ResponseGrootDTO();
            responseGrootDTO.setReceived(receivedGrootDTO.getMessage());
            responseGrootDTO.setTranslated("I am Groot!");

            return responseGrootDTO;
        }
    }
}
