package com.example.practicespringport.controller;

import com.example.practicespringport.domain.User;
import com.example.practicespringport.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

import static com.example.practicespringport.controller.utils.ControllerUtils.getErrors;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String regForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            Map<String, String> errors = getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }

        if(!userService.addUser(user)){
            model.addAttribute("message", "User already exist");
            return "registration";
        }

        return "redirect:/login";
    }
}
