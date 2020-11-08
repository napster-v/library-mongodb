package com.neeraj.libraryApi.book;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("book")
@RestController
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    private Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    private List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PutMapping("{id}")
    private Book updateBook(@RequestBody Book book, @PathVariable @NotNull String id) throws Exception {
        Book optionalBook = bookRepository.findById(id)
                                          .orElseThrow(() -> new Exception("No Book found"));
        book.setId(id);
        return bookRepository.save(book);
    }
}
