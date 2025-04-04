package com.i2i.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@Data
@Document(indexName = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String mrNumber;
    private LocalDate dateOfBirth;
}
