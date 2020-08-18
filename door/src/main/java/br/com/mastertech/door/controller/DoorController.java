package br.com.mastertech.door.controller;

import br.com.mastertech.door.dto.CreateDoorRequest;
import br.com.mastertech.door.dto.DoorResponse;
import br.com.mastertech.door.dto.mapper.DoorMapper;
import br.com.mastertech.door.model.Door;
import br.com.mastertech.door.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/porta")
public class DoorController {

    @Autowired
    private DoorService doorService;

    @Autowired
    private DoorMapper doorMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoorResponse create(@Valid @RequestBody CreateDoorRequest createDoorRequest){
        Door door = doorService.create(doorMapper.toDoor(createDoorRequest));
        return doorMapper.toDoorResponse(door);
    }

    @GetMapping("/{id}")
    public DoorResponse getById(@PathVariable Long id){
        return doorMapper.toDoorResponse(doorService.getById(id));
    }

}
