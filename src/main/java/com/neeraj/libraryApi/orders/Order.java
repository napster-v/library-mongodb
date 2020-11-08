package com.neeraj.libraryApi.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.neeraj.libraryApi.AppBaseModel;
import com.neeraj.libraryApi.book.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class Order extends AppBaseModel {
    private LocalDate dueDate;
    private double amount;
    private double penalty;
    @Transient
    private String bookId;
    @DBRef
    private Book book;

    @JsonIgnore
    public String getBookId() {
        return bookId;
    }

    @JsonProperty
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
