package pl.tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tacos.model.Ingredient;
import pl.tacos.model.Taco;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "pszenna", Ingredient.Type.WRAP),
                new Ingredient("COTO", "kukurydziana", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "mielona wołowina", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "kawałki mięsa", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "pomidory pokrojone w kostkę", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "sałata", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "pikantny sos pomidorowy", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "śmietana", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Taco());
        return "design";
    }



  @PostMapping
  public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors()){
            return "design";
        }
    log.info("Przetwarzanie projektu taco: " + design);

    return "redirect:/orders/current";
  }

//    @PostMapping
//    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "design";
//        }
//
//        // Zapisanie projektu przygotowanego taco...
//        // Tym się zajmiesz w rozdziale 3.
//        log.info("Przetwarzanie projektu taco: " + design);
//
//        return "redirect:/orders/current";
//    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
