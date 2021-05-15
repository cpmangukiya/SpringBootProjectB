package org.example.typicalapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SAMPLE_TABLE")
@NoArgsConstructor
@AllArgsConstructor
public class SampleEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME", unique = true)
    private String name;

    public SampleEntity(String name) {
        this.name = name;
    }
}
