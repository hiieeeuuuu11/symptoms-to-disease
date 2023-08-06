package com.example.health.service.symptom;

import com.example.health.exception.OneSymptomException;
import com.example.health.model.Disease;
import com.example.health.model.Symptom;
import com.example.health.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISymptomService implements SymptomService{

    @Autowired
    SymptomRepository symptomRepository;

    @Override
    public Symptom add(Symptom symptom) {
        return symptomRepository.save(symptom);
    }

    @Override
    public Symptom get(String s) {
        return symptomRepository.findSymptomBySymptomdescribe(s);
    }

    @Override
    public List<Symptom> getAll(List<String> s) throws OneSymptomException {
        if(s.size()==1) throw new OneSymptomException("Co mot dau vao tim an buoi a");
        return s.stream().map(s1 -> symptomRepository.findSymptomBySymptomdescribe(s1)).toList();
    }


}
