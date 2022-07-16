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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String transactionId;

    @ManyToOne
    private Student student;

    @ManyToOne
    Book book;

    @CreationTimestamp
    private Date transactionTime;
    private int fine;
    @Enumerated(value = EnumType.STRING)
    private  TransactionStatus transactionStatus;
    @Enumerated(value = EnumType.STRING)
    private TansactionType tansactionType;

}
