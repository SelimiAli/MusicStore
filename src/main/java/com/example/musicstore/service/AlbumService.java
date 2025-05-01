package com.example.musicstore.service;

import com.example.musicstore.model.Album;
import com.example.musicstore.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    // Hent alle albums
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    // Opret et nyt album
    public void createAlbum(Album album) {
        albumRepository.save(album); // gemmer albummet
    }

    // Hent album efter ID
    public Album getAlbumById(Long id) {
        Optional<Album> album = albumRepository.findById(id);
        return album.orElse(null); // returnerer albummet hvis fundet, ellers null
    }

    // Opdater album med ID
    public void updateAlbum(Long id, Album album) {
        if (albumRepository.existsById(id)) { // tjek om albummet findes
            album.setId(id); // sætte album ID til det eksisterende
            albumRepository.save(album); // gemmer den opdaterede album
        }
    }

    // Slet album med ID
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id); // sletter albummet
    }
}
