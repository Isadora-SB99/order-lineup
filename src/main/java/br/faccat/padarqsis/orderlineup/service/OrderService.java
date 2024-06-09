package br.faccat.padarqsis.orderlineup.service;

import br.faccat.padarqsis.orderlineup.model.OrderDto;
import br.faccat.padarqsis.orderlineup.model.OrderModel;
import br.faccat.padarqsis.orderlineup.model.ProductModel;
import br.faccat.padarqsis.orderlineup.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderModel createOrder(OrderDto orderDto) {
        var order = buildOrderFromDto(orderDto);
        return orderRepository.save(order);
    }

    public List<OrderModel> listOrders() {
        return orderRepository.findAll();
    }

    public OrderModel getOrderById(String id) {
        var optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found");
        } else {
            return optionalOrder.get();
        }
    }

    public OrderModel updateOrder(String id, OrderDto orderDto) {
        var optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found");
        } else {
            var orderModel = buildOrderFromDto(orderDto);
            orderModel.setId(id);
            return orderRepository.save(orderModel);
        }
    }

    public void deleteOrder(String id) {
        var optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("Order not found");
        } else {
            orderRepository.deleteById(id);
        }
    }

    private OrderModel buildOrderFromDto(OrderDto orderDto){
        var products = getOrderProducts(orderDto.getProductCodeList());
        var totalValue = calculateTotalValue(products, orderDto.getProductQuantityList());
        return OrderModel.builder()
                .id(orderDto.getId())
                .code(setOrderCode())
                .productList(products)
                .productQuantityList(orderDto.getProductQuantityList())
                .customerId(orderDto.getCustomerId())
                .totalValue(totalValue)
                .build();
    }

    private List<ProductModel> getOrderProducts(List<Integer> productCodes) {
        return productCodes.stream()
                .map(productService::getProductByCode)
                .collect(Collectors.toList());
    }

    private Integer setOrderCode() {
        return (int) (orderRepository.count() + 1);
    }

    private Double calculateTotalValue(List<ProductModel> products, List<Integer> productQuantities) {
        return products.stream()
                .mapToDouble(product -> product.getPrice() * productQuantities.get(products.indexOf(product)))
                .sum();
    }

    public List<OrderModel> listOrdersByCustomerId(String customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }
}
