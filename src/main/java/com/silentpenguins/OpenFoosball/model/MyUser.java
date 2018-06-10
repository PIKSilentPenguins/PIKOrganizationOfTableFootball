package com.silentpenguins.OpenFoosball.model;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name="user", schema="OpenFoosball")
public class MyUser implements Serializable{

    @Id
    @Column(name="username", unique = true,
            nullable = false, length = 45)
    private String username;

    @Column(name= "password", nullable = false, length = 60)
    private String password;

    @Column(name= "enabled", nullable = false)
    private boolean enabled;

    @Column(name ="userrole", nullable = false)
    private String role;

    public String getRoleString() {
        return role;
    }

    public MyUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public MyUser(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
