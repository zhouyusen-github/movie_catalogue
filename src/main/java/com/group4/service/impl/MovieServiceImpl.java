package com.group4.service.impl;

import com.group4.pojo.Movie;
import com.group4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie selectAllMovie(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM movie WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<Movie>(Movie.class));
    }
}
