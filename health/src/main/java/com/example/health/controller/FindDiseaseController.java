package com.example.health.controller;

import com.example.health.dto.DiseaseResponse;
import com.example.health.dto.SymptomsRequest;
import com.example.health.service.disease.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
public class FindDiseaseController {

    @Autowired
    DiseaseService diseaseService;

    @PostMapping("/symptoms")
    public ResponseEntity<DiseaseResponse> find(@RequestBody SymptomsRequest symptomsRequest){
        return ResponseEntity.ok(diseaseService.findAllDiseaseResponse(symptomsRequest.getSymptoms()));

    }

}
