package com.vipin.recipeapp.domain;

import com.vipin.recipeapp.respositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category category;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getName() {
        final String name = "recipeA";
        category.setName(name);
        assertEquals(name, category.getName());
    }

}