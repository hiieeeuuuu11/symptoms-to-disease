package com.example.health;

import com.example.health.model.Disease;
import com.example.health.model.Symptom;
import com.example.health.repository.DiseaseRepository;
import com.example.health.repository.SymptomRepository;
import com.example.health.service.disease.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthApplication.class, args);
	}

	@Autowired
	DiseaseRepository diseaseRepository;
	@Autowired
	SymptomRepository symptomRepository;

	@Autowired
	DiseaseService diseaseService;

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			diseaseService.findAllDiseasePossible(List.of("sốt"));
		};
	}

}
