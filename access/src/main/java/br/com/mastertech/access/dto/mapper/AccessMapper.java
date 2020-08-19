package br.com.mastertech.access.dto.mapper;

import br.com.mastertech.access.dto.AccessResponse;
import br.com.mastertech.access.dto.CreateAccessRequest;
import br.com.mastertech.access.model.Access;
import br.com.mastertech.access.producer.AccessLog;
import br.com.mastertech.access.repository.AccessRepository;
import org.springframework.stereotype.Component;

@Component
public class AccessMapper {

    public Access toAccess(CreateAccessRequest createAccessRequest){
        Access access = new Access();

        access.setDoorId(createAccessRequest.getDoorId());
        access.setCustomerId(createAccessRequest.getCustomerId());

        return access;
    }

    public AccessResponse toAccessResponse(Access access){
        AccessResponse accessResponse = new AccessResponse();

        accessResponse.setDoorId(access.getDoorId());
        accessResponse.setCustomerId(access.getCustomerId());

        return accessResponse;
    }

    public AccessLog toAccessLog(Long customerId, Long doorId, Boolean hasAccess){
        AccessLog accessLog = new AccessLog();

        accessLog.setCostumerId(customerId);
        accessLog.setDoorId(doorId);
        accessLog.setHasAccess(hasAccess);

        return accessLog;
    }


}
