package com.hand.api.controller;

import com.hand.api.service.IFilmService;
import com.hand.api.service.IPersonService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Exam1Controller {
    @Autowired
    @Qualifier("filmServiceImpl")
    IFilmService filmService;

    @Autowired
    @Qualifier("personServiceImpl")
    IPersonService personService;

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String loginIn(String name,String password){
        Person p= personService.findByName(name);
        if(null!=p.getLast_name()&&password.equals(p.getLast_name())) return "Login Success";
        else return "Login Failed";
    }

    @RequestMapping(value = "/listFilm",method = RequestMethod.GET)
    public List<Film> listFilm(int page, int pageSize){
        return filmService.selectFilm(page,pageSize);
    }

    @RequestMapping(value = "/addPerson",method = RequestMethod.PUT)
    public Integer addPerson(Person p){
        return personService.addPerson(p);
    }

    @RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
    public Person updatePerson(Person p){
        personService.updatePerson(p);
        return personService.findById(p.getCustomer_id());
    }
}
