package com.example.demo2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int venueId;
    private String venueName;
    private String venueImageUrl;
    private int venueCapacity;

    private String venueDescription;
    private String VenueLocation;

    public Venue() {
    }

    public Venue(String VenueName, String venueImageUrl, String venueDescription, String VenueLocation) {
        super();
        this.venueName = VenueName;
        this.venueImageUrl = venueImageUrl;
        this.venueDescription = venueDescription;
        this.VenueLocation = VenueLocation;

    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueImageUrl() {
        return venueImageUrl;
    }

    public void setVenueImageUrl(String venueImageUrl) {
        this.venueImageUrl = venueImageUrl;
    }

    public String getVenueDescription() {
        return venueDescription;
    }

    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }

    public String getVenueLocation() {
        return VenueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        VenueLocation = venueLocation;
    }

    public String toString() {
        return venueId + ":" + venueName + ":" + venueImageUrl + ":" + venueDescription + ":" + VenueLocation;
    }

}
