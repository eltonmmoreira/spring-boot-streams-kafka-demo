package com.demo.order.api.customer;

import com.demo.order.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.demo.order.api.customer.CustomerMapper.mapToEntity;
import static com.demo.order.api.customer.CustomerMapper.mapToResponse;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request) {
        var customer = customerRepository.save(mapToEntity.apply(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToResponse.apply(customer));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(mapToResponse)
                .collect(Collectors.toList());
    }

}
