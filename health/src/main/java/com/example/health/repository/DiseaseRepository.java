package com.example.health.repository;

import com.example.health.model.Disease;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiseaseRepository extends MongoRepository<Disease,String> {
    Disease findByName(String name);
}
