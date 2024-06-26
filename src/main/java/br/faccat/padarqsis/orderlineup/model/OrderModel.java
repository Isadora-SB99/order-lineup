package br.faccat.padarqsis.orderlineup.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderModel {

    private String id;
    private Integer code;
    private List<ProductModel> productList;
    private List<Integer> productQuantityList;
    private CustomerModel customer;
    private Double totalValue;
}
