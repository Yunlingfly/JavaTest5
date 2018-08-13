package com.hand.api.controller;

import com.alibaba.fastjson.JSON;
import com.hand.api.service.IFilmService;
import com.hand.api.service.IPersonService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Exam1Controller {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("filmServiceImpl")
    IFilmService filmService;

    @Autowired
    @Qualifier("personServiceImpl")
    IPersonService personService;

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String loginIn(String name,String password){
        Person p= personService.findByName(name);
        logger.info(JSON.toJSONString("person info:"+p));
        if(null!=p.getLast_name()&&password.equals(p.getLast_name())) return "Login Success";
        else return "Login Failed";
    }

    @RequestMapping(value = "/listFilm",method = RequestMethod.GET)
    public List<Film> listFilm(int page, int pageSize){
        List<Film> list=filmService.selectFilm(page,pageSize);
        logger.info(JSON.toJSONString("Film list:"+list));
        return list;
    }

    @RequestMapping(value = "/addPerson",method = RequestMethod.PUT)
    public Integer addPerson(Person p){
        return personService.addPerson(p);
    }

    @RequestMapping(value = "/getMaxPersonId",method = RequestMethod.GET)
    public Integer getMaxPersonId(){
        Integer maxId=personService.getMaxPersonId();
        logger.info(JSON.toJSONString("MaxPersonId:"+maxId));
        return maxId;
    }

    @RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
    public Person updatePerson(Person p){
        personService.updatePerson(p);
        Person p1=personService.findById(p.getCustomer_id());
        logger.info(JSON.toJSONString("Person info:"+p1));
        return p1;
    }
}
