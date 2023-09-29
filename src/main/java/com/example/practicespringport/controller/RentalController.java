package com.example.practicespringport.controller;

import com.example.practicespringport.domain.Rental;
import com.example.practicespringport.domain.User;
import com.example.practicespringport.repos.CarRepo;
import com.example.practicespringport.repos.RentalRepo;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.example.practicespringport.controller.utils.ControllerUtils.getErrors;

@Controller
public class RentalController {
    private final RentalRepo rentalRepo;
    private final CarRepo carRepo;

    public RentalController(RentalRepo rentalRepo, CarRepo carRepo) {
        this.rentalRepo = rentalRepo;
        this.carRepo = carRepo;
    }

    @PostMapping("/rental")
    public String addRent(
            @AuthenticationPrincipal User user,
            @RequestParam("carId") Long carId,
            @Valid @ModelAttribute(name = "rent")Rental rental,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            Map<String, String> errors = getErrors(bindingResult);
            model.addAttribute("errors", errors);
            return "redirect:/car";
        }
        rental.setUser(user);
        rental.setCar(carRepo.findCarById(carId));
        rentalRepo.save(rental);
        model.addAttribute("success","Successfully rented!");
        return "redirect:/car";
    }
}
