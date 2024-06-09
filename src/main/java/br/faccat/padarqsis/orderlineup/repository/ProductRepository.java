package br.faccat.padarqsis.orderlineup.repository;

import br.faccat.padarqsis.orderlineup.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {

    ProductModel findByCode(Integer code);
}
