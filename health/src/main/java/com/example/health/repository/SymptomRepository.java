package com.example.health.repository;

import com.example.health.model.Disease;
import com.example.health.model.Symptom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SymptomRepository extends MongoRepository<Symptom,String> {
    //Symptom findSymptomBySympton_describe(String s);
    Symptom findSymptomBySymptomdescribe(String s);

}
