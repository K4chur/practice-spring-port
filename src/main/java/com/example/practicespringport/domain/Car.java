package com.example.practicespringport.domain;

import com.example.practicespringport.domain.types.Fuel;
import com.example.practicespringport.domain.types.GearBox;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Марка не може бути пустою.")
    @Length(max = 255, message = "Марка не може бути довше 255 символів")
    private String brand;
    @NotBlank(message = "Модель не може бути пустою.")
    @Length(max = 255, message = "Модель не може бути довше 255 символів")
    private String model;
    @NotEmpty(message = "Об'єм двигуна не може бути пустим.")
    private double engineCapacity;
    @NotEmpty(message = "Тип коробки перемикань має бути вказаним.")
    private GearBox gearBox;
    @NotEmpty(message = "Тип топлива має бути вказаним.")
    private Fuel fuelType;

    @NotEmpty(message = "Денна ціна має бути вказаною.")
    @Min(value = 0, message = "Ціна не може бути від'ємною")
    private double dailyPrice;
    @NotEmpty(message = "Витрати пального мают бути вказаними.")
    private double fuelConsumption;

    private String img;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rental> rentals;
}
