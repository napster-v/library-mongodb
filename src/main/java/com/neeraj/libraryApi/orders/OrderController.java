package com.neeraj.libraryApi.orders;

import com.neeraj.libraryApi.book.Book;
import com.neeraj.libraryApi.book.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {
    private final OrderRepository repository;
    private final BookRepository bookRepository;

    public OrderController(OrderRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) throws Exception {
        Book book = bookRepository.findById(order.getBookId())
                                  .orElseThrow(Exception::new);
        order.setBook(book);
        return repository.save(order);
    }

    @GetMapping
    public List<Order> getOrders() {
        return repository.findAll();
    }
}
