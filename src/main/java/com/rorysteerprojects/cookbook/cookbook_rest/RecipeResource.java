package com.rorysteerprojects.cookbook.cookbook_rest;

import com.rorysteerprojects.cookbook.app_service.CookbookQueryService;
import com.rorysteerprojects.cookbook.cookbook_api.RecipeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final CookbookQueryService cookbookQueryService;

    public RecipeResource(CookbookQueryService cookbookQueryService) {
        this.cookbookQueryService = cookbookQueryService;
    }

    @GetMapping("/recipes")
    public List<RecipeDTO> getRecipes() {
        return cookbookQueryService.fetchRecipes();
    }
//    @GetMapping("/recipes/{id}")
//    public RecipeDto getRecipe(@PathVariable Integer id) {
//        if (id == null) {
//            throw new IllegalArgumentException("id cannot be null");
//        }
//        return RECIPES_LIST.stream().filter(r -> r.id() == id).findFirst().orElse(null);
//    }
    @PostMapping("/recipes")
    public void  createRecipe(@RequestBody RecipeDTO recipe) {
//        RECIPES_LIST.add(new Recipe(3, recipe.name()));
        logger.info("Adding Recipe named {}", recipe.name());
    }
}