package br.faccat.padarqsis.orderlineup.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {

    private String id;
    private Integer code;
    private String name;
    private Double price;
    private Integer stockQuantity;

}
