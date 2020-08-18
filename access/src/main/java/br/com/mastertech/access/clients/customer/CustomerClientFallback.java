package br.com.mastertech.access.clients.customer;

import br.com.mastertech.access.clients.customer.exception.CustomerBadRequestException;

public class CustomerClientFallback implements CustomerClient {
    @Override
    public Customer getById(Long id) {
        throw new CustomerBadRequestException();
    }
}
