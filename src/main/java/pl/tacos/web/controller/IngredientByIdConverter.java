package pl.tacos.web.controller;

import pl.tacos.model.Ingredient;
import pl.tacos.repository.IngredientRepository;

import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private IngredientRepository ingredientRepo;


    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        return optionalIngredient.isPresent() ?
                optionalIngredient.get() : null;
    }
}
