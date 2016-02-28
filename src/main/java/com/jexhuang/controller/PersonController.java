package com.jexhuang.controller;

import com.jexhuang.model.Person;
import com.jexhuang.model.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String getPersonList(ModelMap model) {
        model.addAttribute("personList", personService.listPerson());
        return "/jsp/index";
    }

    @RequestMapping(value = "/person/save", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute Person person, ModelMap model) {
        if (StringUtils.hasText(person.getId())) {
            personService.updatePerson(person);
        } else {
            personService.addPerson(person);
        }
        return "redirect:/mvc/person";
    }

    @RequestMapping(value = "/person/delete", method = RequestMethod.GET)
    public String deletePerson(@ModelAttribute Person person, ModelMap model) {
        personService.deletePerson(person);
        return "redirect:/mvc/person";
    }
}
