package br.com.poc.app1.rest.service;

import br.com.poc.app1.coreH2.DDAEntity;
import br.com.poc.app1.coreH2.DDARepository;
import br.com.poc.app1.coreH2.DDAStatus;
import br.com.poc.app1.rest.gateway.BillDTO;
import br.com.poc.app1.rest.gateway.GetBillsGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class DDAService {

    private final GetBillsGateway gateway;
    private final DDARepository repository;

    public DDAEntity findDDAByCustomer(UUID customerId) {

        return repository.findByCustomer(customerId);

    }

    public List<BillDTO> getUserBills(UUID customerId) {

        long startTime = System.currentTimeMillis();

        final var existsDDAUser = repository.existsByCustomerAndStatus(customerId, DDAStatus.ACTIVE);

        if (Boolean.FALSE.equals(existsDDAUser)) {
            return null;
        }

        final var bills = gateway.getBills(customerId);

        long endTime = System.currentTimeMillis();

        log.info("HTTP response time: {} ms", (endTime - startTime));

        return bills;


    }

    public void getUserBillsAvg(UUID customerId) {

        final var responseTimes = new ArrayList<Long>();

        for (int i = 0; i < 100; i++) {

            long startTime = System.currentTimeMillis();

            final var existsDDAUser = repository.existsByCustomerAndStatus(customerId, DDAStatus.ACTIVE);

            if (Boolean.FALSE.equals(existsDDAUser)) {
                return;
            }

            gateway.getBills(customerId);

            long endTime = System.currentTimeMillis();

            responseTimes.add(endTime - startTime);

        }

        logResponseTimesStatistics(responseTimes);


    }

    private void logResponseTimesStatistics(List<Long> responseTimes) {
        if (responseTimes.isEmpty()) {
            log.info("No response times to analyze.");
            return;
        }

        long minTime = Collections.min(responseTimes);

        long maxTime = Collections.max(responseTimes);

        double totalTime = 0;
        for (long time : responseTimes) {
            totalTime += time;
        }
        double averageTime = totalTime / responseTimes.size();

        log.info("Fastest HTTP Response Time: {} ms", minTime);
        log.info("Slowest HTTP Response Time: {} ms", maxTime);
        log.info("Average HTTP Response Time: {} ms\n", averageTime);
    }
}
