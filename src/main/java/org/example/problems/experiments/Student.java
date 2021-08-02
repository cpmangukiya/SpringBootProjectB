package org.example.problems.experiments;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student extends Object {

    private String name;

    private Integer age;

    private int std;

    private Standard standard;

    public Student(String name) {
        this.name = name;
    }
}


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Data
class Standard extends Object {

    private Integer classValue;

}
