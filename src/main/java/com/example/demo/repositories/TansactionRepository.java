package com.example.demo.repositories;

import com.example.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TansactionRepository  extends JpaRepository<Transaction,Integer> {
}
