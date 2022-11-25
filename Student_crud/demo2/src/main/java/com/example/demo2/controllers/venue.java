package com.example.demo2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dao.VenueDAO;
import com.example.demo2.model.Venue;

@RestController
public class venue {

    @Autowired
    VenueDAO venueDAO;

    @GetMapping("/venue")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<Venue> getuser() {
        return venueDAO.findAll();
    }

    @PostMapping("/venue")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Venue creatUser(@RequestBody Venue venue) {
        return venueDAO.save(venue);
    }

    @GetMapping("/venue/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Venue getUserById(@PathVariable Integer id) {
        Venue user = venueDAO.findById(id).orElse(new Venue());
        return user;
    }

    // update the rest api
    @PutMapping("/venue/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Venue updateUserById(@PathVariable Integer id, @RequestBody Venue venueDetails) {
        Venue user = venueDAO.findById(id).orElse(new Venue());
        user.setVenueId(venueDetails.getVenueId());
        user.setVenueName(venueDetails.getVenueName());
        user.setVenueImageUrl(venueDetails.getVenueImageUrl());
        user.setVenueDescription(venueDetails.getVenueDescription());
        user.setVenueLocation(venueDetails.getVenueLocation());
        Venue updateUser = venueDAO.save(user);
        return updateUser;
    }

    // delete the rest api
    @DeleteMapping("/venue/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Venue deleteUser(@PathVariable Integer id) {
        Venue user = venueDAO.findById(id).orElse(new Venue());
        venueDAO.delete(user);
        return user;
    }

}
