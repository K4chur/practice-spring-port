package com.example.practicespringport.repos;

import com.example.practicespringport.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepo extends JpaRepository<Rental,Long> {

}
