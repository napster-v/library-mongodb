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
}
