package br.com.poc.app2.coreH2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
@AllArgsConstructor
public class MockerService {

    private final BillRepository repository;


    public void loadTable() {

        log.info("Loading table");

        final var mocker = new BillMocker();
        final var bills = new ArrayList<BillEntity>();

        for (int i = 0; i < 400000; i++) {

            bills.add(mocker.buildMockEntity());

        }

        log.info("Saving table");

        repository.saveAll(bills);

        log.info("Load table successfully");



    }

}
