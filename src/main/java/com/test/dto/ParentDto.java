package com.test.dto;

import com.test.validation.CreateChild;
import com.test.validation.Creation;
import com.test.validation.ParentGroupSequenceProvider;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.group.GroupSequenceProvider;
import org.springframework.validation.annotation.Validated;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;

/**
 * Created by Eric on 6/19/2017.
 */
@GroupSequenceProvider(ParentGroupSequenceProvider.class)
public class ParentDto {

    @Valid
    @ConvertGroup(from= CreateChild.class , to = Creation.class)
    private ChildDto childDto;

    private boolean createChild;


    public ChildDto getChildDto() {
        return childDto;
    }

    public void setChildDto(ChildDto childDto) {
        this.childDto = childDto;
    }

    public boolean isCreateChild() {
        return createChild;
    }

    public void setCreateChild(boolean createChild) {
        this.createChild = createChild;
    }

}
