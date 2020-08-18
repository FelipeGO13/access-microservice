package br.com.mastertech.customer.dto.mapper;

import br.com.mastertech.customer.dto.CreateCustomerRequest;
import br.com.mastertech.customer.dto.CustomerResponse;
import br.com.mastertech.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CreateCustomerRequest createCustomerRequest){
        Customer customer = new Customer();

        customer.setName(createCustomerRequest.getName());

        return customer;
    }
    public CustomerResponse toCustomerResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());

        return customerResponse;
    }

}
