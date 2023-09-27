package com.example.practicespringport.domain.validators;

import jakarta.validation.Payload;
import org.aspectj.lang.annotation.DeclareAnnotation;

public @interface AdultAge {
    String message() default "Ви повинні бути повнолітніми.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
