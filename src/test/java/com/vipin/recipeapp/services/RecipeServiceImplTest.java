package com.vipin.recipeapp.services;

import com.vipin.recipeapp.commands.RecipeCommand;
import com.vipin.recipeapp.converters.RecipeCommandToRecipe;
import com.vipin.recipeapp.converters.RecipeToRecipeCommand;
import com.vipin.recipeapp.domain.Recipe;
import com.vipin.recipeapp.respositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService =  new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void findAll() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeData);
        Set<Recipe> recipes = recipeService.findAll();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void findByIdTest()  {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(1L)).thenReturn(java.util.Optional.of(recipe));

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull(recipeReturned);
        verify(recipeRepository, times(1)).findById(1L);
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void findCommandByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(1L)).thenReturn(java.util.Optional.of(recipe));

        RecipeCommand command = new RecipeCommand();
        command.setId(1L);

        when(recipeToRecipeCommand.convert(any())).thenReturn(command);

        RecipeCommand commandReturned = recipeService.findCommandById(1L);

        assertNotNull(commandReturned);
        assertEquals(command.getId(), commandReturned.getId());
        verify(recipeRepository, never()).findAll();
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeToRecipeCommand, times(1)).convert(any());
        verify(recipeCommandToRecipe, never()).convert(any());
    }

    @Test
    void deleteByIdTest(){
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        recipeService.deleteById(1L);

        assertThrows(RuntimeException.class, () -> recipeService.findById(1L));
        verify(recipeRepository, times(1)).deleteById(1L);
    }
}