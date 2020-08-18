package br.com.mastertech.access.clients.door;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DOOR", configuration = DoorClientConfiguration.class)
public interface DoorClient {

    @GetMapping("/porta/{id}")
    Door getById(@PathVariable Long id);
}
