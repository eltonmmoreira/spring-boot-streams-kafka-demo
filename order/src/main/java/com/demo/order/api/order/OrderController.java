package com.demo.order.api.order;

import com.demo.order.exception.NoResultException;
import com.demo.order.repository.CustomerRepository;
import com.demo.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.demo.order.api.order.OrderMapper.mapToEntity;
import static com.demo.order.api.order.OrderMapper.mapToResponse;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;
    private final CustomerRepository customerRepository;

    public OrderController(OrderService orderService, CustomerRepository customerRepository) {
        this.orderService = orderService;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest request) {
        var customer = customerRepository.findById(request.getCustomerId()).orElseThrow();

        var order = mapToEntity.apply(request);
        order.setCustomer(customer);

        order = orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                mapToResponse.apply(order)
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> findAll() {
        return orderService.findAll()
                .stream()
                .map(mapToResponse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cancel(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }

}
