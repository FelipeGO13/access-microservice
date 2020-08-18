package br.com.mastertech.door.dto.mapper;

import br.com.mastertech.door.dto.CreateDoorRequest;
import br.com.mastertech.door.dto.DoorResponse;
import br.com.mastertech.door.model.Door;
import org.springframework.stereotype.Component;

@Component
public class DoorMapper {

    public Door toDoor(CreateDoorRequest createDoorRequest){
        Door door = new Door();

        door.setFloor(createDoorRequest.getFloor());
        door.setRoom(createDoorRequest.getRoom());

        return door;
    }

    public DoorResponse toDoorResponse(Door door){
        DoorResponse doorResponse = new DoorResponse();

        doorResponse.setId(door.getId());
        doorResponse.setFloor(door.getFloor());
        doorResponse.setRoom(door.getRoom());

        return doorResponse;
    }
}
