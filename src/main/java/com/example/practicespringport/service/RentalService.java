package com.example.practicespringport.service;

import com.example.practicespringport.repos.RentalRepo;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    private final RentalRepo rentalRepo;

    public RentalService(RentalRepo rentalRepo) {
        this.rentalRepo = rentalRepo;
    }
}
