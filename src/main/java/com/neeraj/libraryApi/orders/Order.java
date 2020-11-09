package com.neeraj.libraryApi.orders;

import com.neeraj.libraryApi.AppBaseModel;
import com.neeraj.libraryApi.book.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class Order extends AppBaseModel {
    private int days;
    private String description;
    private LocalDate dueDate;
    private double amount;
    private double penalty;
    @DBRef
    private Book book;
}
