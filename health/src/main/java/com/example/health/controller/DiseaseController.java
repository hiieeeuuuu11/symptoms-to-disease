package com.example.health.controller;

import com.example.health.dto.DiseaseData;
import com.example.health.model.Disease;
import com.example.health.service.disease.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disease")
public class DiseaseController {

    @Autowired
    DiseaseService diseaseService;

    @PostMapping("/add")
    public ResponseEntity<DiseaseData> add(@RequestBody DiseaseData diseaseData){
        return ResponseEntity.ok(diseaseService.addAll(diseaseData));
    }

}
