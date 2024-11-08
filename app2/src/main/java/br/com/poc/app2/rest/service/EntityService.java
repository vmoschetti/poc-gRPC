package br.com.poc.app2.rest.service;

import br.com.poc.app2.coreH2.BillEntity;
import br.com.poc.app2.coreH2.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EntityService {

    private final BillRepository billRepository;

    public List<BillEntity> findBillsByCustomer(UUID customer) {

        return billRepository.findByCustomer(customer);

    }


}
