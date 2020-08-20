package br.com.mastertech.access.service;

import br.com.mastertech.access.clients.customer.Customer;
import br.com.mastertech.access.clients.customer.CustomerClient;
import br.com.mastertech.access.clients.door.Door;
import br.com.mastertech.access.clients.door.DoorClient;
import br.com.mastertech.access.dto.mapper.AccessMapper;
import br.com.mastertech.access.exception.AccessAlreadyExistsException;
import br.com.mastertech.access.exception.AccessNotFoundException;
import br.com.mastertech.access.model.Access;
import br.com.mastertech.access.producer.AccessProducer;
import br.com.mastertech.access.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessService {

    @Autowired
    private AccessRepository accessRepository;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private DoorClient doorClient;

    @Autowired
    private AccessMapper accessMapper;

    @Autowired
    private AccessProducer accessProducer;

    public Access create(Access access){
        Customer customer = customerClient.getById(access.getCustomerId());

        Door door = doorClient.getById(access.getDoorId());

        Optional<Access> selectedAccess = accessRepository.getByCustomerIdAndDoorId(customer.getId(), door.getId());

        if(selectedAccess.isPresent()){
            throw new AccessAlreadyExistsException();
        }

        return accessRepository.save(access);
    }

    public Access getByCustomerIdAndDoorId(Long customerId, Long doorId){
        Customer customer = customerClient.getById(customerId);

        Door door = doorClient.getById(doorId);

        Optional<Access> selectedAccess = accessRepository.getByCustomerIdAndDoorId(customer.getId(), door.getId());

        if(!selectedAccess.isPresent()){
            accessProducer.sendToKafka(accessMapper.toAccessLog(customerId, doorId, false));
            throw new AccessNotFoundException();
        }

        accessProducer.sendToKafka(accessMapper.toAccessLog(customerId, doorId, true));
        return selectedAccess.get();
    }

    public void deleteByCustomerIdAndDoorId(Long customerId, Long doorId){
        Customer customer = customerClient.getById(customerId);

        Door door = doorClient.getById(doorId);

        accessRepository.deleteByCustomerIdAndDoorId(customerId, doorId);
    }

}
