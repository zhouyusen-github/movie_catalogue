package com.group4.service.impl;

import com.group4.pojo.Movie;
import com.group4.pojo.MovieJoin;
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
    public List<Movie> selectByFields(String fields) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        stringBuilder.append(fields);
        stringBuilder.append(" FROM movie");
        return jdbcTemplate.query(stringBuilder.toString(), new BeanPropertyRowMapper<Movie>(Movie.class));
    }

    @Override
    public List<Movie> selectAllMovie() {
        return jdbcTemplate.query("SELECT * FROM movie", new BeanPropertyRowMapper<Movie>(Movie.class));
    }

    @Override
    public void insertMovie(int id, String name, double revenue) {
        String sql = "insert into movie value(?,?,?)";
        int rows = jdbcTemplate.update(sql, id, name, revenue);
    }

    @Override
    public void updateMovie(int id, String newName, double newRevenue) {
        String sql = "UPDATE movie SET name = ?, revenue = ? WHERE id = ?";
        jdbcTemplate.update(sql, newName, newRevenue, id);
    }

    @Override
    public void deleteMovie(int id) {
        String sql = "DELETE FROM movie WHERE id= ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<MovieJoin> selectMovieJoin() {
        String sql = "select m.name as movie_name, c.name as country_name From movie m, country c, release_in r, produce_in p Where m.id = r.mid AND m.id = p.mid AND c.id = r.country_id AND c.id = p.country_id;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MovieJoin>(MovieJoin.class));
    }

    @Override
    public int selectMovieLowsNum() {
        String sql = "Select count(*) From movie";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

}
