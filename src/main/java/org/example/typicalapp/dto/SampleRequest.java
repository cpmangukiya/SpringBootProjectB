package org.example.typicalapp.dto;

import lombok.Data;
import org.example.validations.annotation.AbcNumber;

import javax.validation.constraints.NotBlank;

@Data
public class SampleRequest {

    @NotBlank
    @AbcNumber
    private String abcNumber;
}
