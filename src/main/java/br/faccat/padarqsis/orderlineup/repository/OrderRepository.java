package br.faccat.padarqsis.orderlineup.repository;

import br.faccat.padarqsis.orderlineup.model.CustomerModel;
import br.faccat.padarqsis.orderlineup.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, String> {

    List<OrderModel> findAllByCustomer(CustomerModel customer);
}
