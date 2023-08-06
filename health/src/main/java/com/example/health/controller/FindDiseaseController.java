package com.example.health.controller;

import com.example.health.dto.DiseaseResponse;
import com.example.health.dto.SymptomsRequest;
import com.example.health.exception.OneSymptomException;
import com.example.health.service.disease.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/find")
public class FindDiseaseController {

    @Autowired
    DiseaseService diseaseService;

    @PostMapping("/symptoms")
    public ResponseEntity<DiseaseResponse> find(@RequestBody SymptomsRequest symptomsRequest){
        return ResponseEntity.ok(diseaseService.findAllDiseaseResponse(symptomsRequest.getSymptoms()));

    }

    @ExceptionHandler(OneSymptomException.class)
    public ResponseEntity<String> exception(OneSymptomException oneSymptomException){
        return ResponseEntity.ok("NO ONE PARAMETER");
    }


}
