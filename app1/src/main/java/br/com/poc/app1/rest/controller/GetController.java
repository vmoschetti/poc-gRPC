package br.com.poc.app1.rest.controller;

import br.com.poc.app1.coreH2.DDAEntity;
import br.com.poc.app1.rest.service.DDAService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/dda")
public class GetController {

    private final DDAService service;

    @GetMapping("/{customer}")
    public DDAEntity loadTable(@PathVariable(name = "customer") UUID customer) {
        return service.findDDAByCustomer(customer);
    }

}
