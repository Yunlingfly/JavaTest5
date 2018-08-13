package com.hand.api.service;

import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface IFilmService {
    List<Film> selectFilm(int page, int pageSize);
}
