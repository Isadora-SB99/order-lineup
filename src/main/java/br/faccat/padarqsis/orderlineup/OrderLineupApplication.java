package br.faccat.padarqsis.orderlineup;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class OrderLineupApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderLineupApplication.class, args);
    }
//demo-backend-api
}
