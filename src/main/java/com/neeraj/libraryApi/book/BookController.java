package com.neeraj.libraryApi.book;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("book")
@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private BookDTO create(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }


    @GetMapping
    private List<BookDTO> list(@RequestParam(required = false) List<String> categories) {
        return bookService.getBooks(categories);
    }

    @GetMapping("{id}")
    private BookDTO retrieve(@PathVariable @NotNull String id) {
        return bookService.findById(id);
    }

    @PutMapping("{id}")
    private BookDTO update(@PathVariable @NotNull String id, @RequestBody BookDTO book) {
        return bookService.updateBook(id, book);
    }
}
