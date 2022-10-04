package com.egreenfoxacademy.groot.Services;

import com.egreenfoxacademy.groot.DTOs.ReceivedGrootDTO;
import com.egreenfoxacademy.groot.DTOs.ReceivedYonduDTO;
import com.egreenfoxacademy.groot.DTOs.ResponseGrootDTO;

public interface YonduService {

    Object response(ReceivedYonduDTO receivedYonduDTO);
}
