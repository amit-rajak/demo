package com.example.demo.repositories;

import com.example.demo.model.Author;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query("from Author where email=:email")
    Author findByEmail(String email);
}
