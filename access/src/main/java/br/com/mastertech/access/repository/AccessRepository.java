package br.com.mastertech.access.repository;

import br.com.mastertech.access.model.Access;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface AccessRepository extends CrudRepository<Access, Long> {
    Optional<Access> getByCustomerIdAndDoorId(Long customerId, Long doorId);

    @Transactional
    void deleteByCustomerIdAndDoorId(Long customerId, Long doorId);
}
