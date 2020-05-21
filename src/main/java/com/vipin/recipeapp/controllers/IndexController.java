package com.vipin.recipeapp.controllers;

import com.vipin.recipeapp.domain.Category;
import com.vipin.recipeapp.domain.Recipe;
import com.vipin.recipeapp.domain.UnitOfMeasure;
import com.vipin.recipeapp.services.RecipeService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Log
@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }
}
