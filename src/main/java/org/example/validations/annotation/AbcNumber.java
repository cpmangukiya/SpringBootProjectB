package org.example.validations.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;


@Pattern(regexp = "\\s*([1-9][0-9]{1,5})\\s*")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation()
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = {})
@NotNull
public @interface AbcNumber {

    String message() default "Abc is invalid and does not match the pattern '[1-9][0-9]{1,5}'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
