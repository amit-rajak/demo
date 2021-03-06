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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    private int age;
    @Column(unique = true,nullable = false)
    private String contact;
    @CreationTimestamp
    private Date registeredOn;
    private  int tolatfine;


}
