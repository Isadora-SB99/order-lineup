package br.faccat.padarqsis.orderlineup.integration;

import br.faccat.padarqsis.orderlineup.integration.utils.CustomerIntegrationProperties;
import br.faccat.padarqsis.orderlineup.model.CustomerModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class CustomerIntegration {

    private final RestTemplate restTemplate;
    private final CustomerIntegrationProperties integrationProperties;

    public CustomerModel getCustomerById(String customerId) {
        return restTemplate.exchange(
                String.format(integrationProperties.getCustomerPath(), customerId),
                HttpMethod.GET,
                getHttpEntity(),
                CustomerModel.class
        ).getBody();
    }

    public static HttpEntity<String> getHttpEntity() {
        var headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return new HttpEntity<>(headers);
    }
}
