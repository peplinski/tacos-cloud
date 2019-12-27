package pl.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tacos.model.Taco;
@Repository
public interface TacoRepository extends CrudRepository<Taco,Long> {
}
