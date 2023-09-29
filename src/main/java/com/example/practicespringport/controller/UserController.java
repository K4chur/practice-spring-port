package com.example.practicespringport.controller;

import com.example.practicespringport.domain.Rental;
import com.example.practicespringport.domain.User;
import com.example.practicespringport.repos.RentalRepo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final RentalRepo rentalRepo;

    public UserController(RentalRepo rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    @GetMapping("/user/profile")
    public String profile(
            Model model,
            @AuthenticationPrincipal User user
    ){
        model.addAttribute("user", user);
        List<Rental> rentals = rentalRepo.findAll().stream().filter(x -> Objects.equals(x.getUser().getId(), user.getId())).toList();
        model.addAttribute("rentals", rentals);
        return "profile";
    }
}
