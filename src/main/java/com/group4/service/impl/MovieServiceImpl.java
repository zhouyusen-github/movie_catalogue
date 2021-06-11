package com.group4.service.impl;

import com.group4.pojo.Movie;
import com.group4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> selectByName(String name) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE name=?", new Object[] { name }, new BeanPropertyRowMapper<Movie>(Movie.class));
    }

    @Override
    public List<Movie> selectAllMovie() {
        return jdbcTemplate.query("SELECT * FROM movie", new BeanPropertyRowMapper<Movie>(Movie.class));
    }

    @Override
    public void insertMovie(int id, String name, double revenue) {
        String sql = "insert into movie value(?,?,?)";
        int rows = jdbcTemplate.update(sql, id, name, revenue);
        System.out.println("插入行数：" + rows);
    }

    @Override
    public void updateMovie(int id, String newName, double newRevenue) {
        String sql = "UPDATE movie SET name = ?, revenue = ? WHERE id = ?";
        jdbcTemplate.update(sql, newName, newRevenue, id);
    }
}
