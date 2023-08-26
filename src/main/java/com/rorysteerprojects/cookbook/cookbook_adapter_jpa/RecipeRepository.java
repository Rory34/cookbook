package com.rorysteerprojects.cookbook.cookbook_adapter_jpa;

import com.rorysteerprojects.cookbook.domain.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
