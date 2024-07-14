package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String contactNumber;
}
