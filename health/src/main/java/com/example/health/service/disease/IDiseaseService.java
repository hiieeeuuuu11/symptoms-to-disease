package com.example.health.service.disease;

import com.example.health.dto.DiseaseData;
import com.example.health.dto.DiseaseResponse;
import com.example.health.exception.OneSymptomException;
import com.example.health.model.Disease;
import com.example.health.model.Symptom;
import com.example.health.repository.DiseaseRepository;
import com.example.health.repository.SymptomRepository;
import com.example.health.service.symptom.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IDiseaseService implements DiseaseService{

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    SymptomService symptomService;

    @Override
    public Disease add(Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public Disease get(String name) {
        return diseaseRepository.findByName(name);
    }

    @Override
    public DiseaseData addAll(DiseaseData diseaseData){
        Disease disease = Disease.builder()
                .name(diseaseData.getDisease())
                .build();

        diseaseRepository.save(disease);
        List<String> symptoms = diseaseData.getSymptoms();
        symptoms.forEach(s -> {
            Symptom symptom = symptomRepository.findSymptomBySymptomdescribe(s);
            if(symptom==null) {
                symptomRepository.save(Symptom.builder()
                        .diseases(List.of(disease))
                        .symptomdescribe(s)
                        .build());
                }
            else {
                symptom.getDiseases().add(disease);
                symptomRepository.save(symptom);
                }
            });
        return diseaseData;
    }

    @Override
    public List<List<Disease>> findAllDiseasePossible(List<String> s) throws OneSymptomException {
        List<Symptom> symptoms = symptomService.getAll(s);
        Map<String,Integer> statistics = new HashMap<>();

        symptoms.forEach(symptom ->
                {
                    List<Disease> diseases = symptom.getDiseases();
                    diseases.forEach(d -> {
                        if(statistics.containsKey(d.getId()))
                        {
                            statistics.put(d.getId(),statistics.get(d.getId())+1);
                        }
                        else
                        {
                            statistics.put(d.getId(),1);
                        }
                    });
                }
                );
        //System.out.println(statistics);
        final int[] max = {0,0};
        statistics.forEach((k, v) -> {
            if(v>max[0]) {
                max[1]=max[0];
                max[0]=v;
            }
            else if(v<max[0]){
                if(v>max[1]){
                    max[1]=v;
                }
            }

        });
        List<List<Disease>> out = new ArrayList<>();
        for(int i=0;i< max.length;i++){
            int f = i;
            List<Disease> diseases = new ArrayList<>();
            statistics.forEach((k, v)-> {
                if(v==max[f]) diseases.add(diseaseRepository.findById(k).orElse(null));
            });
            out.add(diseases);
        }
        return out;
    }

    @Override
    public DiseaseResponse findAllDiseaseResponse(List<String> symptoms) throws OneSymptomException{
        List<List<Disease>> ld = findAllDiseasePossible(symptoms);

        return DiseaseResponse.builder()
                .mostpossibility(ld.get(0))
                .secondpossibility(ld.get(1))
                .build();
    }

    @Override
    public List<Disease> findAllbySymptom(String s){
        return symptomRepository.findSymptomBySymptomdescribe(s).getDiseases();
    }

}
