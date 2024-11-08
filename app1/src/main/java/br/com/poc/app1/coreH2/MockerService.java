package br.com.poc.app1.coreH2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
@AllArgsConstructor
public class MockerService {

    private final DDARepository repository;


    public void loadTable() {

        log.info("Loading table");

        final var mocker = new DDAMocker();
        final var ddas = new ArrayList<DDAEntity>();

        ddas.add(mocker.buildDefaultCustomer());

        for (int i = 0; i < 40000; i++) {

            ddas.add(mocker.buildMockEntity());

        }

        log.info("Saving table");

        repository.saveAll(ddas);

        log.info("Load table successfully");


    }

}
