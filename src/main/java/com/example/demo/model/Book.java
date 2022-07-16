package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Author author;
    @ManyToOne
    Student student;
    private String publisher;
    private int cost;
    private boolean isAvailble;
    @CreationTimestamp
    private Date addedOn;
}
