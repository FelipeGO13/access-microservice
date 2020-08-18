package br.com.mastertech.customer.service;

import br.com.mastertech.customer.exception.CustomerNotFoundException;
import br.com.mastertech.customer.model.Customer;
import br.com.mastertech.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getById(Long id){
        Optional<Customer> selectedCustomer = customerRepository.findById(id);

        if(!selectedCustomer.isPresent()){
           throw new CustomerNotFoundException();
        }

        return selectedCustomer.get();
    }
}
