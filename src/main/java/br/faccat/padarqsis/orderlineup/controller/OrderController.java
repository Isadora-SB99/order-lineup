package br.faccat.padarqsis.orderlineup.controller;

import br.faccat.padarqsis.orderlineup.model.OrderDto;
import br.faccat.padarqsis.orderlineup.model.OrderModel;
import br.faccat.padarqsis.orderlineup.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public OrderModel createOrder(@Valid @RequestBody OrderDto order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/list")
    public List<OrderModel> listOrders() {
        return orderService.listOrders();
    }

    @GetMapping("/get/{id}")
    public OrderModel getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderModel> listOrdersByCustomerId(@RequestParam String customerId) {
        return orderService.listOrdersByCustomerId(customerId);
    }

    @PutMapping("/update/{id}")
    public OrderModel updateOrder(@PathVariable String id, @Valid @RequestBody OrderDto order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }
}
