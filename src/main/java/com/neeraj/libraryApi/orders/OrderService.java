package com.neeraj.libraryApi.orders;

import com.neeraj.libraryApi.book.Book;
import com.neeraj.libraryApi.book.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    public OrderService(BookRepository bookRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Book book = bookRepository.findById(orderDTO.getBookId())
                                  .orElseThrow();

        orderDTO.setAmount(getAmount(orderDTO, book));
        orderDTO.setDueDate(getDueDate(orderDTO));
        orderDTO.setBook(book);

        Order order = orderRepository.save(OrderMapper.INSTANCE.toModel(orderDTO));

        return OrderMapper.INSTANCE.toDto(order);
    }

    @NotNull
    private LocalDate getDueDate(OrderDTO orderDTO) {
        return LocalDate.now()
                        .plusDays(orderDTO.getDays());
    }

    private double getAmount(OrderDTO orderDTO, Book book) {
        return book.getPricePerDay() * orderDTO.getDays();
    }

    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return OrderMapper.INSTANCE.toListDto(orders);
    }
}
