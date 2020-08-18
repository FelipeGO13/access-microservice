package br.com.mastertech.access.clients.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Serviço de clientes indisponível")
public class CustomerBadRequestException extends RuntimeException{
}
