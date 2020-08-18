package br.com.mastertech.access.clients.door;

import br.com.mastertech.access.clients.door.exception.DoorBadRequestException;

public class DoorClientFallback implements DoorClient {
    @Override
    public Door getById(Long id) {
        throw new DoorBadRequestException();
    }
}
