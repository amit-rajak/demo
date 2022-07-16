package com.example.demo.services;

import com.example.demo.model.Author;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    AuthorRepository authorRepository;
    public Author getAuthorByEmail(String email)
    {
        return authorRepository.findByEmail(email);
    }

    public Author addAuthor(Author author)
    {

        return authorRepository.save(author);
    }
}
