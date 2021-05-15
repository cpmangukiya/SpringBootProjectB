package org.example.typicalapp.exception;

import javax.validation.constraints.Null;

public class InvalidValueException extends Exception {

    public InvalidValueException(@Null String value, String operation) {
        super(String.format("Invalid value %s found for operation %s", value, operation));
    }

}
