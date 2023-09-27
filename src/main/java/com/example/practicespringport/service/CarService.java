package com.example.practicespringport.service;

import com.example.practicespringport.repos.CarRepo;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private  final CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }
}
