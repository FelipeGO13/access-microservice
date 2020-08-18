package br.com.mastertech.access.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Acesso já existente")
public class AccessAlreadyExistsException extends RuntimeException{
}
