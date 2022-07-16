package com.example.demo.services;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.requests.BookceateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;
    @Transactional
    public  void addBook(BookceateRequest bookCreateRequest)
    {
        Book book=bookCreateRequest.toBook();
        Author author =authorService.getAuthorByEmail(bookCreateRequest.getEmail());
        if(author==null)
        {
            author=Author.builder()
                    .name(bookCreateRequest.getName())
                    .country(bookCreateRequest.getCountry())
                    .email(bookCreateRequest.getEmail())
                    .build();

            authorService.addAuthor(author);
        }

        book.setAuthor(author);
        bookRepository.save(book);

    }

    public Book getBookById(int id)
    {
        return bookRepository.findById(id).orElse(null);
    }
    public void addOrUpatedBook(Book book)
    {
        bookRepository.save(book);
    }

}
