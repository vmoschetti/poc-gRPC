package br.com.poc.app1.rest.gateway;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
public class GetBillsGateway {

    public List<BillDTO> getBills(UUID customer) {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange("http://localhost:8090/bills/" + customer,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BillDTO>>() {}).getBody();

    }

}
