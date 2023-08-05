package com.example.health.service.symptom;

import com.example.health.model.Disease;
import com.example.health.model.Symptom;

import java.util.List;

public interface SymptomService {
    Symptom add(Symptom symptom);
    Symptom get(String s);
    List<Symptom> getAll(List<String> s);
}
