package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.api.service.IFilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import com.hand.infra.mapper.IFilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class FilmServiceImpl implements IFilmService {
    @Autowired
    IFilmMapper iFilmMapper;

    @Override
    public List<Film> selectFilm(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);

        return iFilmMapper.getAll();
    }
}
