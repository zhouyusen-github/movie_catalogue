package com.group4.controller;

import com.group4.pojo.UserAvgRating;
import com.group4.pojo.UserName;

import com.group4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService UserService;

    @RequestMapping(value = "/avgrating")
    public List<UserAvgRating> getUserAvgRating(HttpServletRequest request) {
        List<UserAvgRating> result = UserService.selectUserAvgRating();
        return result;
    }

    @RequestMapping(value = "/rateallmovie")
    public List<UserName> getUserRateAllMovie(HttpServletRequest request) {
        List<UserName> result = UserService.selectUserRatingAllMovie();
        return result;
    }
}
