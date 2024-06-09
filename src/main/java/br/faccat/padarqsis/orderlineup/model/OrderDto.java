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
public class OrderDto {

    private String id;
    private List<Integer> productCodeList;
    private List<Integer> productQuantityList;
    private String customerId;
}
