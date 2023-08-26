package com.rorysteerprojects.cookbook.app_service;

import com.rorysteerprojects.cookbook.cookbook_adapter_jpa.RecipeRepository;
import com.rorysteerprojects.cookbook.cookbook_api.RecipeDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CookbookQueryService {
    private final RecipeRepository recipeRepository;

    public CookbookQueryService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> fetchRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(r -> new RecipeDTO(r.getId(), r.getName(), r.getDateLastCooked()))
                .toList();
    }
}
