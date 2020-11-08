package com.neeraj.libraryApi.book;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("book")
@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    private Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }


    @GetMapping
    private List<Book> getBooks(@RequestParam(required = false) List<String> categories) {
        if (categories != null) {
            return bookRepository.findByCategoriesLike(categories);
        }
        return bookRepository.findAll();
    }

    @PutMapping("{id}")
    private Book updateBook(@RequestBody Book book, @PathVariable @NotNull String id) throws Exception {
        Book bookFound = bookRepository.findById(id)
                                       .orElseThrow(() -> new Exception("No Book found"));
        book.setId(bookFound.getId());
        return bookRepository.save(book);
    }
}
