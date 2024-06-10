package br.faccat.padarqsis.orderlineup.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private final String baseUrl;

    public RestTemplateConfig(@Value("${url.base}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().rootUri(this.baseUrl).build();
    }
}
