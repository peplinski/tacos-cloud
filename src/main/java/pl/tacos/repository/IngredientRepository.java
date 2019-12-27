package pl.tacos.repository;

import pl.tacos.model.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient>findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
