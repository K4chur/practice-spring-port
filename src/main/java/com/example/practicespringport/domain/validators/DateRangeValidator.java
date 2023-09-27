package com.example.practicespringport.domain.validators;

import com.example.practicespringport.domain.Rental;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, Rental> {
    @Override
    public void initialize(DateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(Rental entity, ConstraintValidatorContext context) {
        if (entity.getDateFrom() == null || entity.getDateTo() == null) {
            return true; // Let other validators handle null values.
        }

        return entity.getDateFrom().before(entity.getDateTo());
    }
}
