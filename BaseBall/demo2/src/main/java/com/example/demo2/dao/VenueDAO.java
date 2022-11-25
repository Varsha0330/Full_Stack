package com.example.demo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.Venue;

public interface VenueDAO extends JpaRepository<Venue, Integer> {

}
