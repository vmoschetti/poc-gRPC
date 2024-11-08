package br.com.poc.app2.coreH2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class MockerService {

    private final BillRepository app2BillRepository;


    public void loadTable() {

        log.info("Loading table");

        final var mocker = new BillMocker();

        for (int i = 0; i < 10000; i++) {

            app2BillRepository.save(mocker.buildMockEntity());

        }

        log.info("Load table successfully");



    }

}
