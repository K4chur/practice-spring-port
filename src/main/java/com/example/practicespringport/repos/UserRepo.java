package com.example.practicespringport.repos;

import com.example.practicespringport.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
