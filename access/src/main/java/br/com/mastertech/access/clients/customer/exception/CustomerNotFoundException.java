package br.com.mastertech.access.clients.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cliente não encontrado")
public class CustomerNotFoundException extends RuntimeException{
}
