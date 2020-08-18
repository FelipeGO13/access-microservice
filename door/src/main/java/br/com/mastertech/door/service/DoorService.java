package br.com.mastertech.door.service;

import br.com.mastertech.door.exception.DoorNotFoundException;
import br.com.mastertech.door.model.Door;
import br.com.mastertech.door.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoorService {

    @Autowired
    private DoorRepository doorRepository;

    public Door create(Door door){
        return doorRepository.save(door);
    }

    public Door getById(Long id){
        Optional<Door> selectedDoor = doorRepository.findById(id);

        if(!selectedDoor.isPresent()){
            throw new DoorNotFoundException();
        }

        return selectedDoor.get();
    }
}
