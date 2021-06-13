package com.group4.service;

import com.group4.pojo.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> selectByName(String name);
    public List<Movie> selectByFields(String fields);
    public List<Movie> selectAllMovie();
    public void insertMovie(int id, String name, double revenue);
    public void updateMovie(int id, String newName, double newRevenue);
    public void deleteMovie(int id);
}
