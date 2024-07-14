package com.example.demo.controllers;

import com.example.demo.models.Listing;
import com.example.demo.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listings", listingService.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String showAddListingForm(Model model) {
        model.addAttribute("listing", new Listing());
        return "addListing";
    }

    @PostMapping("/add")
    public String addListing(@ModelAttribute Listing listing) {
        listingService.saveListing(listing);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String viewListingDetails(@PathVariable("id") Long id, Model model) {
        Listing listing = listingService.findById(id);
        model.addAttribute("listing", listing);
        return "details";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteListing(@PathVariable("id") Long id) {
        listingService.deleteListing(id);
        return "redirect:/";
    }
}
