package com.hand.api.service;

import com.hand.domain.entity.Person;

public interface IPersonService {
    Person findById(Integer id);
    Person findByName(String name);
    Integer addPerson(Person p);
    void updatePerson(Person p);
    void deletePerson(Integer id);
    Integer getMaxPersonId();
}
