package com.myproj.jwt.security;

import com.myproj.jwt.dao.UserDao;
import com.myproj.jwt.entity.Role;
import com.myproj.jwt.entity.User;
import com.myproj.jwt.response.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User registerNewUser(User user) {

        return userDao.save(user);
    }

    public FinalResponse someRandomAPI(String user) {

        FinalResponse response=FinalResponse.builder()
                .message("Stored")
                .status(true)
                .data(user)
                .build();

        return response;
    }
}
