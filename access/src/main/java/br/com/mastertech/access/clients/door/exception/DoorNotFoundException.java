package br.com.mastertech.access.clients.door.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Porta não encontrada")
public class DoorNotFoundException extends RuntimeException{
}
