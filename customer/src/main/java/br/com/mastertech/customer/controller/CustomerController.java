package br.com.mastertech.customer.controller;

import br.com.mastertech.customer.dto.CreateCustomerRequest;
import br.com.mastertech.customer.dto.CustomerResponse;
import br.com.mastertech.customer.dto.mapper.CustomerMapper;
import br.com.mastertech.customer.model.Customer;
import br.com.mastertech.customer.service.CustomerService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        Customer customer = customerService.create(customerMapper.toCustomer(createCustomerRequest));

        return customerMapper.toCustomerResponse(customer);
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable Long id){
        return customerMapper.toCustomerResponse(customerService.getById(id));
    }

}
