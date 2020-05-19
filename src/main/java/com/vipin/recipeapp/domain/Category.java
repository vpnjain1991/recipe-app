package com.vipin.recipeapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"recipe"})
public class Category extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
