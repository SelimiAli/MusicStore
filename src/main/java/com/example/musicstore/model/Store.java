package com.example.musicstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Tilføj address-feltet
    private String address;  // Adresse-felt til butik

    @ManyToMany
    @JoinTable(
            name = "store_album",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> albums;
}
