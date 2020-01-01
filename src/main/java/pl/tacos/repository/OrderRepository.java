package pl.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tacos.model.Order;


public interface OrderRepository extends CrudRepository<Order,Long> {
}
