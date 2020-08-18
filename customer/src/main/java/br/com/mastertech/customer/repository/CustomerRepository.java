package br.com.mastertech.customer.repository;

import br.com.mastertech.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
