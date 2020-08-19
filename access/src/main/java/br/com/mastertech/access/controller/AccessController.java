package br.com.mastertech.access.controller;

import br.com.mastertech.access.dto.AccessResponse;
import br.com.mastertech.access.dto.CreateAccessRequest;
import br.com.mastertech.access.dto.mapper.AccessMapper;
import br.com.mastertech.access.exception.AccessNotFoundException;
import br.com.mastertech.access.model.Access;
import br.com.mastertech.access.producer.AccessProducer;
import br.com.mastertech.access.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/acesso")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @Autowired
    private AccessMapper accessMapper;

    @Autowired
    private AccessProducer accessProducer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccessResponse create(@Valid @RequestBody CreateAccessRequest createAccessRequest){
        Access access = accessService.create(accessMapper.toAccess(createAccessRequest));

        return accessMapper.toAccessResponse(access);
    }

    @GetMapping("/{cliente_id}/{porta_id}")
    public AccessResponse getByCustomerIdAndDoorId(@PathVariable("cliente_id") Long customerId, @PathVariable("porta_id") Long doorId){
        AccessResponse access;

        try{
            access = accessMapper.toAccessResponse(accessService.getByCustomerIdAndDoorId(customerId, doorId));
        } catch (AccessNotFoundException e){
            accessProducer.sendToKafka(accessMapper.toAccessLog(customerId, doorId, false));
            throw e;
        }

        accessProducer.sendToKafka(accessMapper.toAccessLog(customerId, doorId, false));
        return access;
    }


    @DeleteMapping("/{cliente_id}/{porta_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByCustomerIdAndDoorId(@PathVariable("cliente_id") Long customerId, @PathVariable("porta_id") Long doorId){
        accessService.deleteByCustomerIdAndDoorId(customerId, doorId);
    }

}
