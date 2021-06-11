package com.group4.controller;

import com.group4.pojo.Movie;
import com.group4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getMovie(HttpServletRequest request) {
        String fields=request.getParameter("fields");
        String name=request.getParameter("name");
        List<Movie> result = null;
        if (fields == null) {
            if (name == null) {
                result =movieService.selectAllMovie();
            } else {
                result =movieService.selectByName(name);
            }
        } else {
        }


        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertMovie(HttpServletRequest request) {
        String idString=request.getParameter("id");
        String name=request.getParameter("name");
        String revenueString=request.getParameter("revenue");

        int id = Integer.valueOf(idString);
        double revenue = Double.valueOf(revenueString);
        movieService.insertMovie(id, name, revenue);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public String deleteMovie(@PathVariable("id") String id,HttpServletRequest request) {
        return id;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public String updateMovie(@PathVariable("id") String id,HttpServletRequest request) {
        String name=request.getParameter("name");
        return id+name;
    }
}
