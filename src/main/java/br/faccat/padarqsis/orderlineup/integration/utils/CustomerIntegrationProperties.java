package br.faccat.padarqsis.orderlineup.integration.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CustomerIntegrationProperties {

    @Value("${customer.integration.get-customer-path}")
    private String customerPath;
}
