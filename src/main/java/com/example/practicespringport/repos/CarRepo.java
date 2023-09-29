package com.example.practicespringport.repos;

import com.example.practicespringport.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {
    Car findCarById(Long carId);
}
