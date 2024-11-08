package br.com.poc.app1.coreH2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class MockerService {

    private final DDARepository repository;


    public void loadTable() {

        log.info("Loading table");

        final var mocker = new DDAMocker();

        final var defaultCustomer = mocker.buildDefaultCustomer();

        repository.save(defaultCustomer);

        for (int i = 0; i < 300; i++) {

            repository.save(mocker.buildMockEntity());

        }

        log.info("Load table successfully");



    }

}
