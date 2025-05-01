package com.example.musicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_signup")
@Data
public class NotificationSignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("notificationSignUps") // Undgår potentielle loops
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties("notificationSignUps")
    private Album album;

    private LocalDateTime signupDate = LocalDateTime.now();
}
