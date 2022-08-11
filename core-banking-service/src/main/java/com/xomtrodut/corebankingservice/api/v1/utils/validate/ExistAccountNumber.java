package com.xomtrodut.corebankingservice.api.v1.utils.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistAccountNumberValidator.class)
@Documented
public @interface ExistAccountNumber {
    String message() default "Account number isn't exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
