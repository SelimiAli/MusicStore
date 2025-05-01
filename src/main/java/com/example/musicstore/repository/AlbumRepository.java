package com.example.musicstore.repository;

import com.example.musicstore.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    // Alle CRUD-operations her
}
