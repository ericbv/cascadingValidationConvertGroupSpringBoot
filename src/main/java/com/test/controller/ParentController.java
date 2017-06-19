package com.test.controller;

import com.test.dto.ParentDto;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by Eric on 6/19/2017.
 */
@Controller
@RequestMapping("/")
public class ParentController{
    static Logger log = Logger.getLogger(ParentController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("parentDto",new ParentDto());
        return "test";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String doPost(@Valid ParentDto parentDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach( error-> log.error(error));
            return "redirect: /error";
        }else{
            return "redirect: /";
        }

    }



}
