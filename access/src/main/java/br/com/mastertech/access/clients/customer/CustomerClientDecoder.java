package br.com.mastertech.access.clients.customer;

import br.com.mastertech.access.clients.customer.exception.CustomerNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomerClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404){
            throw new CustomerNotFoundException();
        }

        return errorDecoder.decode(s, response);
    }
}
