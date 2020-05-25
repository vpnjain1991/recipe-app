package com.vipin.recipeapp.services;

import com.vipin.recipeapp.commands.RecipeCommand;
import com.vipin.recipeapp.converters.RecipeCommandToRecipe;
import com.vipin.recipeapp.converters.RecipeToRecipeCommand;
import com.vipin.recipeapp.domain.Recipe;
import com.vipin.recipeapp.respositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeServiceIT {
    public static final String NEW_NAME = "New Name";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfName() {
        //given
        Recipe recipe = recipeRepository.findAll().iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(recipe);

        //when
        testRecipeCommand.setName(NEW_NAME);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        assertEquals(NEW_NAME, savedRecipeCommand.getName());
        assertEquals(testRecipeCommand.getId(), savedRecipeCommand.getId());
        assertEquals(testRecipeCommand.getCategories().size(), savedRecipeCommand.getCategories().size());
        assertEquals(testRecipeCommand.getIngredients().size(), savedRecipeCommand.getIngredients().size());
    }
}
