package com.neeraj.libraryApi.book;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookDTO extends BaseDTO {
    private String title;
    private String isbn;
    private Double pricePerDay;
    private Double penaltyPerDay;
    private List<String> categories = new ArrayList<>();
}
