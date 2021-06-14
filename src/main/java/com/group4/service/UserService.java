package com.group4.service;


import com.group4.pojo.UserAvgRating;
import com.group4.pojo.UserName;

import java.util.List;

public interface UserService {
    public List<UserAvgRating> selectUserAvgRating();
    public List<UserName> selectUserRatingAllMovie();


}
