package com.vipin.recipeapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"recipe"})
public class Notes extends BaseEntity{
    private String notes;
    @OneToOne
    private Recipe recipe;
}
