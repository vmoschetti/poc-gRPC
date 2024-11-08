package br.com.poc.app1.rest.gateway;

import java.time.LocalDate;
import java.util.UUID;

public record BillDTO(UUID id, UUID customer, String name, String barCode, LocalDate dueDate, Long amount) {

}
