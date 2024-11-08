package br.com.poc.app2.coreH2;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class BillMocker {

    private final AtomicInteger counter = new AtomicInteger();
    private final Random random = new Random();
    private final UUID defaultCustomerId = UUID.fromString("0cdd6038-7a60-41d5-aa1d-98b0a8247b0e");

    public BillEntity buildMockEntity() {

        final var customer = random.nextInt(10000) + 1 <= 7 ? defaultCustomerId : UUID.randomUUID();
        final var dueDate = LocalDate.now().plusDays(random.nextInt(100));

        return new BillEntity(UUID.randomUUID(), customer, "Bill ".concat(String.valueOf(counter.getAndIncrement())),
                String.valueOf(random.nextExponential()), dueDate, random.nextLong(200000) + 100);
    }

}
