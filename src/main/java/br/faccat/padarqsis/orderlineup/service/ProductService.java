package br.faccat.padarqsis.orderlineup.service;

import br.faccat.padarqsis.orderlineup.model.ProductModel;
import br.faccat.padarqsis.orderlineup.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public List<ProductModel> listProducts() {
        return productRepository.findAll();
    }

    public ProductModel getProductById(String id) {
        var optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        } else {
            return optionalProduct.get();
        }
    }

    public ProductModel getProductByCode(Integer code) {
        return productRepository.findByCode(code);
    }

    public ProductModel updateProduct(String id, ProductModel product) {
        var optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        } else {
            product.setId(id);
            return productRepository.save(product);
        }
    }

    public void deleteProduct(String id) {
        var optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        } else {
            productRepository.deleteById(id);
        }
    }
}
