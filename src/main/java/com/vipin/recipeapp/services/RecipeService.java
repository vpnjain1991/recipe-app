package com.vipin.recipeapp.services;

import com.vipin.recipeapp.commands.RecipeCommand;
import com.vipin.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> findAll();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long commandId);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long id);
}
