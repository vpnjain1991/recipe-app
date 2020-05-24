package com.vipin.recipeapp.commands;

import com.vipin.recipeapp.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String name;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
}
