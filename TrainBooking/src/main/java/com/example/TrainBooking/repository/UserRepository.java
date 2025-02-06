package com.example.TrainBooking.repository;

import com.example.TrainBooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);  // Custom method to find a user by email
}
