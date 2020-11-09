package com.neeraj.libraryApi.orders;

import com.neeraj.libraryApi.book.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {
    private final OrderService service;
    private final OrderRepository repository;

    public OrderController(OrderRepository repository,
                           BookRepository bookRepository,
                           OrderService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return service.createOrder(orderDTO);
    }

    @GetMapping
    public List<OrderDTO> getOrders() {
        return service.findAll();
    }
}
