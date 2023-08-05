package com.example.health.dto;

import com.example.health.model.Disease;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiseaseResponse {
    List<Disease> mostpossibility;
    List<Disease> secondpossibility;
}
