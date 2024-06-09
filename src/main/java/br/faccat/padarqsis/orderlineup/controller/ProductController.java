package br.faccat.padarqsis.orderlineup.controller;

import br.faccat.padarqsis.orderlineup.model.ProductModel;
import br.faccat.padarqsis.orderlineup.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ProductModel createProduct(@Valid @RequestBody ProductModel product) {
        return productService.createProduct(product);
    }

    @GetMapping("/list")
    public List<ProductModel> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/get/{id}")
    public ProductModel getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public ProductModel updateProduct(@PathVariable String id, @Valid @RequestBody ProductModel product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
