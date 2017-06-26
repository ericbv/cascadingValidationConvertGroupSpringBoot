package com.test.dto;

import com.test.validation.Creation;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.GroupSequence;

/**
 * Created by Eric on 6/19/2017.
 */
public class ChildDto {

    @NotEmpty(groups = Creation.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
