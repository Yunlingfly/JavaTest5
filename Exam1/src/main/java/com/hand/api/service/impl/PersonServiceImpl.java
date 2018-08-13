package com.hand.api.service.impl;

import com.hand.api.service.IPersonService;
import com.hand.domain.entity.Person;
import com.hand.infra.mapper.IPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    IPersonMapper iPersonMapper;

    @Override
    public Person findByName(String name) {
        return iPersonMapper.findByName(name);
    }

    @Override
    public Integer addPerson(Person p) {
        return iPersonMapper.insert(p);
    }

    @Override
    public void updatePerson(Person p) {
        iPersonMapper.update(p);
    }

    @Override
    public Person findById(Integer id) {
        return iPersonMapper.findById(id);
    }

    @Override
    public void deletePerson(Integer id) {
        iPersonMapper.delete(id);
    }

    @Override
    public Integer getMaxPersonId() {
        return iPersonMapper.selectMaxId();
    }
}
