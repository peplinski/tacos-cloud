package pl.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tacos.model.Taco;

public interface TacoRepository extends CrudRepository<Taco,Long> {
}
