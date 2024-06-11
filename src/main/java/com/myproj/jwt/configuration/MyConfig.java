package com.myproj.jwt.configuration;

import com.myproj.jwt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import java.util.List;

@Configuration
public class MyConfig {

    @Autowired
    private UserDao userDao;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailService(){
        List<com.myproj.jwt.entity.User> allUsers=userDao.findAll();
        InMemoryUserDetailsManager memory=new InMemoryUserDetailsManager();

        for (com.myproj.jwt.entity.User singleUser: allUsers){

            String getRole = userDao.getRoles(singleUser.getUserName());

            UserDetails myUsers= User
                    .withUsername(singleUser.getUserName())
                    .password(passwordEncoder().encode(singleUser.getUserPassword()))
                    .roles(getRole)
                    .build();
            memory.createUser(myUsers);
        }

//master to main
        return memory;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
