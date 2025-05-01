package com.example.musicstore.repository;

import com.example.musicstore.model.NotificationSignUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationSignUpRepository extends JpaRepository<NotificationSignUp, Long> {
    // måske brug for findByCustomerId senere
}
