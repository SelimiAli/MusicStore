package com.example.musicstore.controller;

import com.example.musicstore.model.Album;
import com.example.musicstore.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // Hent alle albums
    @GetMapping
    public String getAllAlbums(Model model) {
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "albums"; // Sender til albums.html
    }

    // Vis formular for at oprette et nyt album
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("album", new Album()); // Ny album-model til formularen
        return "create-album"; // Sender til create-album.html
    }

    // Vis formular for at redigere et eksisterende album
    @GetMapping("/edit/{id}")
    public String editAlbum(@PathVariable Long id, Model model) {
        Album album = albumService.getAlbumById(id);
        model.addAttribute("album", album); // Album der skal redigeres
        return "edit-album"; // Sender til edit-album.html
    }

    // Gem album (nyt eller opdateret)
    @PostMapping("/save")
    public String saveAlbum(@ModelAttribute Album album) {
        if (album.getId() != null) {
            albumService.updateAlbum(album.getId(), album); // Opdater album
        } else {
            albumService.createAlbum(album); // Opret nyt album
        }
        return "redirect:/albums"; // Omdirigerer til albums liste
    }

    @PostMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id); // Slet album
        return "redirect:/albums"; // Omdirigerer til albums liste
    }

}
