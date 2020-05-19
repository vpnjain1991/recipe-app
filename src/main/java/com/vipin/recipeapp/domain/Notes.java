package com.vipin.recipeapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@ToString(exclude = {"recipe"})
public class Notes extends BaseEntity{
    @Lob
    private String notes;

    @OneToOne
    private Recipe recipe;
}
