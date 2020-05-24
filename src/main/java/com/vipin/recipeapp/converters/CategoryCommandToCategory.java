package com.vipin.recipeapp.converters;

import com.vipin.recipeapp.commands.CategoryCommand;
import com.vipin.recipeapp.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null){
            return null;
        }
        final Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getName());
        return category;
    }
}
