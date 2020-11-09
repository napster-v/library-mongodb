package com.neeraj.libraryApi.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.neeraj.libraryApi.book.BaseDTO;
import com.neeraj.libraryApi.book.Book;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class OrderDTO extends BaseDTO {
    private String description;
    private int days;
    private LocalDate dueDate;
    private double amount;
    private double penalty;
    private String bookId;
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
