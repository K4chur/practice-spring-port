package com.example.practicespringport.domain;

import com.example.practicespringport.domain.validators.DateRange;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "rental")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DateRange(message = "Дата початку аренди має бути раніше її закінчення.")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Ви не можете арендувати авто в минулому.")
    @DateRange(message = "Дата початку аренди має бути раніше її закінчення.")
    private Date dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Ви не можете арендувати авто в минулому.")
    @DateRange(message = "Дата початку аренди має бути раніше її закінчення.")
    private Date dateTo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
