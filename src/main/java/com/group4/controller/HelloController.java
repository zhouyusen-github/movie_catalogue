package com.group4.controller;

import com.group4.pojo.Movie;
import com.group4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/movies")
@RestController
public class HelloController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMovie(HttpServletRequest request) {
        String fields=request.getParameter("fields");
        String name=request.getParameter("name");
        Movie a =movieService.selectAllMovie(1);
        System.out.println(a);
        return fields+name;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertMovie(HttpServletRequest request) {
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        return id+name;
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
