package br.com.poc.app2.coreH2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, UUID> {

    List<BillEntity> findByCustomer(UUID customer);
}
