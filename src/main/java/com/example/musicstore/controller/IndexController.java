package com.example.musicstore.controller;

import com.example.musicstore.model.Album;
import com.example.musicstore.model.Store;
import com.example.musicstore.model.Customer;
import com.example.musicstore.repository.AlbumRepository;
import com.example.musicstore.repository.StoreRepository;
import com.example.musicstore.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final AlbumRepository albumRepository;
    private final StoreRepository storeRepository;
    private final CustomerRepository customerRepository;

    public IndexController(AlbumRepository albumRepository, StoreRepository storeRepository, CustomerRepository customerRepository) {
        this.albumRepository = albumRepository;
        this.storeRepository = storeRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")  // Denne rute mapper til "/" som er hjem-siden
    public String getIndexPage(Model model) {
        // Hent data fra repositorys
        List<Album> albums = albumRepository.findAll();
        List<Store> stores = storeRepository.findAll();
        List<Customer> customers = customerRepository.findAll();

        // Send data til Thymeleaf-templaten
        model.addAttribute("albums", albums);
        model.addAttribute("stores", stores);
        model.addAttribute("customers", customers);

        return "index";  // Thymeleaf-siden index.html
    }
}
