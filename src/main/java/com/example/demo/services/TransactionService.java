package com.example.demo.services;

import com.example.demo.model.*;
import com.example.demo.repositories.TansactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;
@Service
public class TransactionService {

    @Autowired
    TansactionRepository tansactionRepository;
    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;
    @Transactional
    public String issueBook(int bookId,int studentId) throws Exception {
        Book book= bookService.getBookById(bookId);
        if(book==null || !book.isAvailble())
            return "Book is not available";


        Student student= studentService.getStudent(studentId);

        if(student==null)
            return "Student not found";


        Transaction transaction=Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDEING)
                .tansactionType(TansactionType.RETURN)
                .student(student)
                .book(book)
                .build();

        try {
            tansactionRepository.save(transaction);
            book.setAvailble(false);
            book.setStudent(student);
            bookService.addOrUpatedBook(book);

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            tansactionRepository.save(transaction);
        }
        catch (Exception exception)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            tansactionRepository.save(transaction);
            throw new Exception("Trannsaction:"+transaction.getTransactionId()+"has failed");
        }
        return transaction.getTransactionId();

    }

    public int getFine(int bookId,int studentId)
    {
     return 0;
    }

    @Transactional
    public String returnBook(int bookId,int studentId) throws Exception {
     Book book =bookService.getBookById(bookId);

     if(book==null || book.isAvailble())
     return  "Book is not found or not avilable";

     Student student=studentService.getStudent(studentId);
     if(student==null || book.getStudent().getId()!=studentId)
             return "student not found or";


        Transaction transaction=Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDEING)
                .tansactionType(TansactionType.RETURN)
                .book(book)
                .student(student)
                .build();

        try {
            tansactionRepository.save(transaction);
            book.setAvailble(true);
            book.setStudent(null);
            bookService.addOrUpatedBook(book);

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            tansactionRepository.save(transaction);
        }
        catch (Exception exception)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            tansactionRepository.save(transaction);
            book.setAvailble(false);
            book.setStudent(student);
            throw new Exception("Trannsaction:"+transaction.getTransactionId()+"has failed");
        }
        return transaction.getTransactionId();



    }
}
