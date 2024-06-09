package br.faccat.padarqsis.orderlineup.rabbitMQ;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerProducer {

    private AmqpTemplate amqpTemplate;

    public void generateCustomer(String customerId){
        amqpTemplate.convertAndSend(
                "existing-client-exchange",
                "existing-client-rout-key",
                customerId
        );
    }
}
