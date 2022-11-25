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

import com.example.demo2.dao.EventDAO;
import com.example.demo2.model.EventModel;

@RestController
public class Event {

    @Autowired
    EventDAO eventDAO;

    @GetMapping("/event")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<EventModel> getuser() {
        return eventDAO.findAll();
    }

    @PostMapping("/event")
    @CrossOrigin(origins = "http://localhost:4200/")
    public EventModel creatUser(@RequestBody EventModel event) {
        return eventDAO.save(event);
    }

    @GetMapping("/event/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public EventModel getUserById(@PathVariable Integer id) {
        EventModel event = eventDAO.findById(id).orElse(new EventModel());
        return event;
    }

    // update the rest api
    @PutMapping("/event/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public EventModel updateUserById(@PathVariable Integer id, @RequestBody EventModel eventDetails) {
        EventModel user = eventDAO.findById(id).orElse(new EventModel());
        user.setEventId(eventDetails.getEventId());
        user.setVenueName(eventDetails.getVenueName());
        user.setEventName(eventDetails.getEventName());
        user.setApplicantName(eventDetails.getApplicantName());
        user.setApplicantMobile(eventDetails.getApplicantMobile());
        user.setApplicantEmail(eventDetails.getApplicantEmail());
        user.setEventAddress(eventDetails.getEventAddress());
        user.setEventDate(eventDetails.getEventDate());
        user.setEventTime(eventDetails.getEventTime());
        user.setTeamMembers(eventDetails.getTeamMembers());
        EventModel updateEvent = eventDAO.save(user);
        return updateEvent;
    }

    // delete the rest api
    @DeleteMapping("/event/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public EventModel deleteUser(@PathVariable Integer id) {
        EventModel event = eventDAO.findById(id).orElse(new EventModel());
        eventDAO.delete(event);
        return event;
    }

}
