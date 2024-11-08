package br.com.poc.app1.coreH2;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class DDAMocker {

    private final AtomicInteger counter = new AtomicInteger();
    private final Random random = new Random();
    private final UUID defaultCustomerId = UUID.fromString("0cdd6038-7a60-41d5-aa1d-98b0a8247b0e");

    public DDAEntity buildMockEntity() {

        return new DDAEntity(UUID.randomUUID(), UUID.randomUUID(), "DDA mock ".concat(String.valueOf(counter.getAndIncrement())),
                DDAStatus.get(random.nextInt(5) + 1));
    }

    public DDAEntity buildDefaultCustomer() {

        return new DDAEntity(UUID.randomUUID(), defaultCustomerId, "DDA da Silva Pags",
                DDAStatus.ACTIVE);
    }
}
