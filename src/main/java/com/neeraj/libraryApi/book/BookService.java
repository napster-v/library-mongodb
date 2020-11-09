package com.neeraj.libraryApi.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookDTO> getBooks(List<String> categories) {
        List<Book> books;

        if (categories != null) {
            books = repository.findByCategoriesLike(categories);
        } else {
            books = repository.findAll();
        }

        return BookMapper.INSTANCE.toListDto(books);

    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = repository.save(BookMapper.INSTANCE.toModel(bookDTO));
        return BookMapper.INSTANCE.toDto(book);
    }

    public BookDTO updateBook(String id, BookDTO bookDTO) {
        Book bookFound = repository.findById(id)
                                   .orElseThrow(() -> new RuntimeException("No Book found"));
        bookDTO.setId(bookFound.getId());
        Book book = repository.save(BookMapper.INSTANCE.toModel(bookDTO));
        return BookMapper.INSTANCE.toDto(book);
    }

    public BookDTO findById(String id) {
        Book book = repository.findById(id)
                                   .orElseThrow(() -> new RuntimeException("No Book found"));
        return BookMapper.INSTANCE.toDto(book);
    }
}
