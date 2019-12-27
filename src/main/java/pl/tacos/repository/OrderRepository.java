package pl.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tacos.model.Order;

import java.util.List;
@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order>findByDeliveryZip(String deliveryZip);
}
