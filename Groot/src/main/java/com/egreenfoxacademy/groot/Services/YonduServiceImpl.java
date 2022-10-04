package com.egreenfoxacademy.groot.Services;

import com.egreenfoxacademy.groot.DTOs.ErrorDTO;
import com.egreenfoxacademy.groot.DTOs.ReceivedYonduDTO;
import com.egreenfoxacademy.groot.DTOs.ResponseGrootDTO;
import com.egreenfoxacademy.groot.DTOs.ResponseYonduDTO;
import org.springframework.stereotype.Service;

@Service
public class YonduServiceImpl implements YonduService{
    @Override
    public Object response(ReceivedYonduDTO receivedYonduDTO) {

        if(receivedYonduDTO.getDistance() == null || receivedYonduDTO.getTime() == null || receivedYonduDTO.getTime() <= 0) {

            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setError("No values or incorrect time");

            return errorDTO;
        } else {

            ResponseYonduDTO responseYonduDTO = new ResponseYonduDTO();
            responseYonduDTO.setDistance(receivedYonduDTO.getDistance());
            responseYonduDTO.setTime(receivedYonduDTO.getTime());
            responseYonduDTO.setSpeed(receivedYonduDTO.getDistance()/ receivedYonduDTO.getTime());

            return responseYonduDTO;
        }
    }
}
