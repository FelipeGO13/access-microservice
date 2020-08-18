package br.com.mastertech.access.clients.door;

import br.com.mastertech.access.clients.door.exception.DoorNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class DoorClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
       if(response.status() == 404){
           throw new DoorNotFoundException();
       }
        return errorDecoder.decode(s, response);
    }

}
