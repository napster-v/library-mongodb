package com.neeraj.libraryApi.book;

import com.neeraj.libraryApi.AppBaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class Book extends AppBaseModel {
    private String title;
    private String isbn;
    private Double pricePerDay;
    private Double penaltyPerDay;
    private List<String> categories = new ArrayList<>();
    public Book(String title,
                String isbn,
                Double pricePerDay,
                Double penaltyPerDay,
                List<String> categories) {
        this.title = title;
        this.isbn = isbn;
        this.pricePerDay = pricePerDay;
        this.penaltyPerDay = penaltyPerDay;
        this.categories = categories;
    }
}
