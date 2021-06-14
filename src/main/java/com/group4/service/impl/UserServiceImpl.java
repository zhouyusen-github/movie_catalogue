package com.group4.service.impl;

import com.group4.pojo.UserAvgRating;
import com.group4.pojo.UserName;
import com.group4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserAvgRating> selectUserAvgRating() {
        String sql = "Select m.id, m.name, avg(rating) as rating From movie m, rate r Where m.id = r.mid Group by m.id, m.name;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserAvgRating>(UserAvgRating.class));
    }

    @Override
    public List<UserName> selectUserRatingAllMovie(){
        String sql = "Select u.username From user u Where NOT EXISTS (select m.id from movie m where not exists (select r.mid from rate r where r.user_id = u.id and r.mid = m.id));";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserName>(UserName.class));
    }



}
