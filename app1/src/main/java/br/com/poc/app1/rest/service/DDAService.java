package br.com.poc.app1.rest.service;

import br.com.poc.app1.coreH2.DDAEntity;
import br.com.poc.app1.coreH2.DDARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DDAService {

    private final DDARepository repository;

    public DDAEntity findDDAByCustomer(UUID customer) {

        return repository.findByCustomer(customer);

    }
}
