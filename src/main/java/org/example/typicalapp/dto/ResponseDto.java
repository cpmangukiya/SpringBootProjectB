package org.example.typicalapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    @NonNull
    private Boolean isSuccess;

    @NonNull
    private String response;

    private String error;
}
