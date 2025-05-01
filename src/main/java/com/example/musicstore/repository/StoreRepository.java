package com.example.musicstore.repository;

import com.example.musicstore.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    // Standard-CRUD Operations til Store
}
