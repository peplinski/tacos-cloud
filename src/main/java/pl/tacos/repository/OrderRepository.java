package pl.tacos.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import pl.tacos.model.Order;
import pl.tacos.model.User;

import java.util.List;


public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);
}
