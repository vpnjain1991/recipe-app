package com.vipin.recipeapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"recipe"})
public class Ingredient extends BaseEntity {
    private String name;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    private UnitOfMeasure uom;

    public Ingredient(String name, BigDecimal amount, UnitOfMeasure uom) {
        this.name = name;
        this.amount = amount;
        this.uom = uom;
    }
}