package com.example.demo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;*/

import com.example.demo2.model.User;

import java.util.*;

public interface UserDAO extends JpaRepository<User, Integer> {
    /* follow protocol */
    List<User> findByName(String name);

    List<User> findByIdGreaterThan(int id);

    /*
     * @Query("from User where tech=?1 and order by name")
     * List<User> findByTechSorted(String tech);
     */

}
