package br.com.poc.app2.rest.service;

import br.com.poc.app2.coreH2.BillEntity;
import br.com.poc.app2.coreH2.BillRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class EntityService {

    private final BillRepository billRepository;

    public List<BillEntity> findBillsByCustomer(UUID customer) {

        long start = System.currentTimeMillis();

        final var bills = billRepository.findByCustomer(customer);

        long end = System.currentTimeMillis();

        log.info("Query response time: {} ms", (end - start));

        return bills;

    }


}
