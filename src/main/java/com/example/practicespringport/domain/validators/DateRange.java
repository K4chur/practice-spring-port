package com.example.practicespringport.domain.validators;

import jakarta.validation.Payload;

public @interface DateRange {
    String message() default "Не валідно вказана дата.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
