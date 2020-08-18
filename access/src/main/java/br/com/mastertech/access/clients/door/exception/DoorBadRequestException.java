package br.com.mastertech.access.clients.door.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Serviço de portas indisponível")
public class DoorBadRequestException extends RuntimeException{
}
