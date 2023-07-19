package org.example.typicalapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@org.hibernate.annotations.Entity()
@Table(name = "SAMPLE_TABLE")
@NoArgsConstructor
@AllArgsConstructor
@SecondaryTable(name = "a")
@SecondaryTable(name = "b")
public class SampleEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME", unique = true)
    private String name;

    private int a;

    private long b;

    private double c;

    public SampleEntity(String name) {
        this.name = name;
        int result = 1 * 59 + (int)this.getC();
    }
}
