package com.example.musicstore.controller;

import com.example.musicstore.model.NotificationSignUp;
import com.example.musicstore.model.Customer;
import com.example.musicstore.model.Album;
import com.example.musicstore.repository.NotificationSignUpRepository;
import com.example.musicstore.repository.CustomerRepository;
import com.example.musicstore.repository.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationSignUpController {

    private final NotificationSignUpRepository signupRepo;
    private final CustomerRepository customerRepo;
    private final AlbumRepository albumRepo;

    public NotificationSignUpController(
            NotificationSignUpRepository signupRepo,
            CustomerRepository customerRepo,
            AlbumRepository albumRepo
    ) {
        this.signupRepo = signupRepo;
        this.customerRepo = customerRepo;
        this.albumRepo = albumRepo;
    }

    // tilmeld en kunde til notifikation
    @PostMapping
    public NotificationSignUp signup(@RequestParam Long customerId, @RequestParam Long albumId) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        Optional<Album> album = albumRepo.findById(albumId);

        if (customer.isPresent() && album.isPresent()) {
            NotificationSignUp signup = new NotificationSignUp();
            signup.setCustomer(customer.get());
            signup.setAlbum(album.get());
            return signupRepo.save(signup);
        }

        return null;
    }

    // henter alle notifikationstilmeldinger
    @GetMapping
    public List<NotificationSignUp> getAllSignups() {
        return signupRepo.findAll();
    }
}
