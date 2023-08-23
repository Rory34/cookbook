package com.rorysteerprojects.cookbook.cookbook_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RecipeResource {

    private static List<Recipe> RECIPES_LIST = List.of(
            new Recipe(1, "R1", LocalDate.of(2023, 2, 3)),
            new Recipe(2, "R2", LocalDate.of(2023, 3, 3))
    );
    private Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return RECIPES_LIST;
    }
    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        return RECIPES_LIST.stream().filter(r -> r.id() == id).findFirst().orElse(null);
    }
    @PostMapping("/recipes")
    public void  createRecipe(@RequestBody Recipe recipe) {
//        RECIPES_LIST.add(new Recipe(3, recipe.name()));
        logger.info("Adding Recipe named {}", recipe.name());
    }
}
//SecurityProperties.BASIC_AUTH_ORDER
record Recipe (int id, String name, LocalDate lastCooked) {}
