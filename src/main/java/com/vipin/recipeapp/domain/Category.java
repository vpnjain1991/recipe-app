package com.vipin.recipeapp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = {"recipes"})
public class Category extends BaseEntity{
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
