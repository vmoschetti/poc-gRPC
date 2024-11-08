package br.com.poc.app2.rest.controller;

import br.com.poc.app2.coreH2.BillEntity;
import br.com.poc.app2.rest.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/bills")
public class GetController {

    private final EntityService service;

    @GetMapping("/{customer}")
    public List<BillEntity> loadTable(@PathVariable(name = "customer") UUID customer) {
        return service.findBillsByCustomer(customer);
    }

}
