package com.example.demo.services;

import com.example.demo.models.Listing;
import com.example.demo.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    public Listing findById(Long id) {
        return listingRepository.findById(id).orElse(null);
    }

    public void saveListing(Listing listing) {
        listingRepository.save(listing);
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}
