package com.example.musicstore.controller;

import com.example.musicstore.model.Store;
import com.example.musicstore.model.Album;
import com.example.musicstore.repository.StoreRepository;
import com.example.musicstore.repository.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreRepository storeRepo;
    private final AlbumRepository albumRepo;

    public StoreController(StoreRepository storeRepo, AlbumRepository albumRepo) {
        this.storeRepo = storeRepo;
        this.albumRepo = albumRepo;
    }

    // Opretter en butik
    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeRepo.save(store);
    }

    // Tilføjer et album til en butik
    @PostMapping("/{storeId}/albums/{albumId}")
    public Store addAlbumToStore(@PathVariable Long storeId, @PathVariable Long albumId) {
        Optional<Store> storeOpt = storeRepo.findById(storeId);
        Optional<Album> albumOpt = albumRepo.findById(albumId);

        if (storeOpt.isPresent() && albumOpt.isPresent()) {
            Store store = storeOpt.get();
            store.getAlbums().add(albumOpt.get());
            return storeRepo.save(store);
        }
        return null;
    }

    // Henter alle butikker
    @GetMapping
    public Iterable<Store> getAllStores() {
        return storeRepo.findAll();
    }
}
