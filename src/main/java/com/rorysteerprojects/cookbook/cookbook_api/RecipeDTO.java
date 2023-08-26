package com.rorysteerprojects.cookbook.cookbook_api;

import java.time.LocalDate;

public record RecipeDTO(int id, String name, LocalDate lastCooked) {}
