package com.example.practicespringport.domain.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AdultAgeValidator implements ConstraintValidator<AdultAge, LocalDate> {
    @Override
    public void initialize(AdultAge constraintAnnotation) {
        // You can perform any initialization here if needed.
    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) {
            return true; // Let other validators handle null values.
        }

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);

        return age.getYears() >= 18;
    }
}
