package com.example.demo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.EventModel;

public interface EventDAO extends JpaRepository<EventModel, Integer> {

}
