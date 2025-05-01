package com.example.musicstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private Integer releaseYear;
    private String genre;
    private Boolean availableOnVinyl = false;
}
