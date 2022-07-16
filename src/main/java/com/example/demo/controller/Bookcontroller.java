package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.requests.BookceateRequest;
import com.example.demo.services.BookService;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Bookcontroller {

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@RequestBody BookceateRequest bookceateRequest)
    {

        bookService.addBook(bookceateRequest);
    }
    @GetMapping("/book")
    public Book getBook(@RequestParam("id")int id)
    {

        return  bookService.getBookById(id);
    }
}
