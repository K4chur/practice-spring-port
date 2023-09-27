package com.example.practicespringport.domain;

import com.example.practicespringport.domain.validators.DateRange;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotEmpty(message = "Ви повинні вказати дату початку аренди.")
    @Future(message = "Ви не можете арендувати авто в минулому.")
    private Date dateFrom;

    @NotEmpty(message = "Ви повинні вказати дату закінчення аренди.")
    @Future(message = "Ви не можете арендувати авто в минулому.")
    private Date dateTo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
