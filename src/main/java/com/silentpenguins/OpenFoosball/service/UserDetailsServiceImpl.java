package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.MyUserDao;
import com.silentpenguins.OpenFoosball.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MyUserDao myUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = findUserbyUsername(username);

        User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles(user.getRoleString());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

    private MyUser findUserbyUsername(String username) {
        if(username.equalsIgnoreCase(username)) {
            return myUserDao.findByUsername(username);
        }
        return null;
    }
}
