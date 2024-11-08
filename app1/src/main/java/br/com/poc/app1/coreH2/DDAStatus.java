package br.com.poc.app1.coreH2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum DDAStatus {

    ACTIVE(1),
    INACTIVE(2),
    WAITING_INCLUSION(3),
    WAITING_EXCLUSION(4),
    ERROR(5);

    private final long value;

    public static DDAStatus get(int value) {

        return Arrays.stream(DDAStatus.values()).filter(status -> status.value == value).findFirst().orElse(null);

    }
}
