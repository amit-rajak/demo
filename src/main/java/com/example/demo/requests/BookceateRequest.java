package com.example.demo.requests;

import com.example.demo.model.Book;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookceateRequest {

    private int id;
    private String name;
    private int cost;
    private  String publisher;

    private String authorName;
    private String country;
    private String email;

    public Book toBook()
    {
        return Book.builder()
                .cost(cost)
                .name(name)
                .publisher(publisher)
                .isAvailble(true)
                .build();
    }
}
