package com.hand.infra.mapper;

import com.hand.domain.entity.Film;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IFilmMapper {
    @Select("SELECT * FROM film")
    @Results({
            @Result(property = "film_id", column = "film_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description")
    })
    List<Film> getAll();
}
