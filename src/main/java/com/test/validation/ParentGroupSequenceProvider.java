package com.test.validation;

import com.test.controller.ParentController;
import com.test.dto.ParentDto;
import org.apache.log4j.Logger;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 6/19/2017.
 */
public class ParentGroupSequenceProvider implements DefaultGroupSequenceProvider<ParentDto> {

    static Logger log = Logger.getLogger(ParentGroupSequenceProvider.class.getName());
    @Override
    public List<Class<?>> getValidationGroups(ParentDto parentDto) {
        List<Class<?>> sequence = new ArrayList<Class<?>>();

      /*
       * ContactDataBis must be added to the returned list so that the validator gets to know
       * the default validation rules, at the very least.
       */
        sequence.add(ParentDto.class);

        if (parentDto == null)
            return sequence;
      /*
       *  Here, we can implement a certain logic to determine what are the additional group of rules
       *  that must be applied.
       */
        if(parentDto.isCreateChild()){
            sequence.add(CreateChild.class);
            log.info("Added CreateChild to groups");

        }

        return sequence;
    }
}
