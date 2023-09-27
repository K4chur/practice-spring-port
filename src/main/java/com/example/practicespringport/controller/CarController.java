package com.example.practicespringport.controller;

import com.example.practicespringport.repos.CarRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
    private final CarRepo carRepo;

    public CarController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping("/car")
    public String carList(
            Model model
    ){
        model.addAttribute("cars",carRepo.findAll());
        return "ourCars";
    }
}
