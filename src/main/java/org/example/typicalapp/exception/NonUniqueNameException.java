package org.example.typicalapp.exception;

import javax.validation.constraints.Null;

public class NonUniqueNameException extends Exception {

    public NonUniqueNameException(@Null String value) {
        super(String.format("Name %s already exists in records", value));
    }

}
