package br.com.poc.app1.coreH2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DDARepository extends JpaRepository<DDAEntity, UUID> {

    DDAEntity findByCustomer(UUID customer);
}
