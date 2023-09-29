package com.example.practicespringport.controller;

import com.example.practicespringport.domain.Car;
import com.example.practicespringport.domain.Rental;
import com.example.practicespringport.domain.types.Fuel;
import com.example.practicespringport.domain.types.GearBox;
import com.example.practicespringport.repos.CarRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        model.addAttribute("rent",new Rental());
        return "ourCars";
    }

    @GetMapping("/car/search")
    public String carSearch(
        Model model,
        @RequestParam(value = "priceLow",required = false, defaultValue = "-1") double priceLow,
        @RequestParam(value = "priceHigh",required = false, defaultValue = "9999") double priceHigh,
        @RequestParam(value = "fuelType",required = false, defaultValue = "None") String fuelType,
        @RequestParam(value = "gearboxType",required = false, defaultValue = "None") String gearboxType
    ){
        model.addAttribute("rent",new Rental());

        List<Car> cars = carRepo.findAll();
        cars = cars.stream().filter(x -> x.getDailyPrice() > priceLow && x.getDailyPrice() < priceHigh).collect(Collectors.toList());
        Fuel fuelLast;
        if(!Objects.equals(fuelType, "None")){
            fuelLast = Fuel.valueOf(fuelType);
            cars = cars.stream().filter(x -> x.getFuelType() == fuelLast).collect(Collectors.toList());
        }
        GearBox gearLast;
        if(!Objects.equals(gearboxType, "None")){
            gearLast = GearBox.valueOf(gearboxType);
            cars = cars.stream().filter(x -> x.getGearBox() == gearLast).collect(Collectors.toList());
        }
        model.addAttribute("cars", cars);

        return "searchCars";
    }
}
