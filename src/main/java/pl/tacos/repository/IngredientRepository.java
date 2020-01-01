package pl.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tacos.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
