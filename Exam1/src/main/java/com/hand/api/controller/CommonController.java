package com.hand.api.controller;

import com.github.pagehelper.PageHelper;
import com.hand.infra.mapper.CommonCountryMapper;
import com.hand.infra.util.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {
    @Autowired
    CommonCountryMapper commonCountryMapper;

    @RequestMapping(value = "/getAllCountry", method = RequestMethod.GET)
    public List<Country> listAll(int pageNum, int pageSize) {
        System.out.println("使用通用Mapper查询结果");
        PageHelper.startPage(pageNum, pageSize);
        return commonCountryMapper.selectAll();
    }

    @RequestMapping(value = "/updateOneCountry",method = RequestMethod.PUT)
    public List<Country> updateOne(Country c) {
        System.out.println("使用通用Mapper更新数据");
        commonCountryMapper.updateByPrimaryKey(c);
        return commonCountryMapper.select(c);
    }
}