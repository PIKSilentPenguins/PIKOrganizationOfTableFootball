package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.model.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

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
        if(username.equalsIgnoreCase("admin")) {
            return new MyUser(username, "admin", "ADMIN");
        }
        return null;
    }
}
