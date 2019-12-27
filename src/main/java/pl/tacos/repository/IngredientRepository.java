package pl.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tacos.model.Ingredient;
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
