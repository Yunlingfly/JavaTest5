package com.hand.infra.mapper;

import com.hand.domain.entity.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IPersonMapper {
    @Select("SELECT first_name, last_name FROM customer WHERE first_name = #{first_name}")
    @Results({
            @Result(property = "first_name", column = "first_name"),
            @Result(property = "last_name", column = "last_name")
    })
    Person findByName(@Param(value = "first_name") String first_name);

    @Select("SELECT customer_id,first_name,last_name,email FROM customer WHERE customer_id = #{customer_id}")
    @Results({
            @Result(property = "customer_id", column = "customer_id"),
            @Result(property = "first_name", column = "first_name"),
            @Result(property = "last_name", column = "last_name"),
            @Result(property = "email", column = "email")
    })
    Person findById(@Param(value = "customer_id") Integer customer_id);

    @Select("SELECT max(customer_id)customer_id FROM customer")
    Integer selectMaxId();

    @Insert("INSERT INTO customer(store_id,first_name,last_name,email,address_id) VALUES(1,#{first_name},#{last_name},#{email},#{address_id})")
    int insert(Person person);

    @Update("UPDATE customer SET first_name=#{first_name} WHERE customer_id =#{customer_id}")
    void update(Person user);

    @Delete("DELETE FROM customer WHERE customer_id =#{id}")
    void delete(Integer id);
}
