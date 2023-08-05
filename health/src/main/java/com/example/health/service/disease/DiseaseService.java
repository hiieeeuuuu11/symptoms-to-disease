package com.example.health.service.disease;

import com.example.health.dto.DiseaseData;
import com.example.health.dto.DiseaseResponse;
import com.example.health.model.Disease;
import com.example.health.model.Symptom;

import java.util.List;

public interface DiseaseService {
    Disease add(Disease disease);
    Disease get(String name);
    DiseaseData addAll(DiseaseData diseaseData);
    List<List<Disease>> findAllDiseasePossible(List<String> symptoms);
    DiseaseResponse findAllDiseaseResponse(List<String> symptoms);
    List<Disease> findAllbySymptom(String s);
}
