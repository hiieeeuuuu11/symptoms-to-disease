package com.example.health.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Symptom {

    @Id
    String id;

    String symptomdescribe;

    @DBRef
    List<Disease> diseases;

}
