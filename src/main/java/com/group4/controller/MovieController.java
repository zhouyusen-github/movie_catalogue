package com.group4.controller;

import com.group4.pojo.Movie;
import com.group4.pojo.MovieJoin;
import com.group4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getMovie(HttpServletRequest request) {
        String fields = request.getParameter("fields");
        String name = request.getParameter("name");
        List<Movie> result = null;
        if (fields == null) {
            if (name == null) {
                result = movieService.selectAllMovie();
            } else {
                result = movieService.selectByName(name);
            }
        } else {
            result = movieService.selectByFields(fields);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertMovie(HttpServletRequest request) {
        String idString = request.getParameter("id");
        String name = request.getParameter("name");
        String revenueString = request.getParameter("revenue");

        int id = Integer.valueOf(idString);
        double revenue = Double.valueOf(revenueString);
        movieService.insertMovie(id, name, revenue);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateMovie(@PathVariable("id") int id, HttpServletRequest request) {
        String newName = request.getParameter("name");
        String newRevenueString = request.getParameter("revenue");
        double newRevenue = Double.valueOf(newRevenueString);
        movieService.updateMovie(id, newName, newRevenue);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable("id") int id, HttpServletRequest request) {
        movieService.deleteMovie(id);
    }

    @RequestMapping(value = "/join")
    public List<MovieJoin> getJoin(HttpServletRequest request) {
        List<MovieJoin> result = movieService.selectMovieJoin();
        return result;
    }

    @RequestMapping(value = "/rownum")
    public int getMovieLowsNum(HttpServletRequest request) {
        int result = movieService.selectMovieLowsNum();
        return result;
    }
}
