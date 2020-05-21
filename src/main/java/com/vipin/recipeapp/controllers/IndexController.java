package com.vipin.recipeapp.controllers;

import com.vipin.recipeapp.domain.Category;
import com.vipin.recipeapp.domain.UnitOfMeasure;
import com.vipin.recipeapp.respositories.CategoryRepository;
import com.vipin.recipeapp.respositories.UnitOfMeasureRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Log
@Controller
public class IndexController {
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public IndexController(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String index(){
        Optional<Category> categoryOptional = categoryRepository.findByName("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("Pinch");
        log.info("Cat Id " + categoryOptional.get().getId());
        log.info("unit of measure " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
