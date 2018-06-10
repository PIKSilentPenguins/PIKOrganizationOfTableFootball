package com.silentpenguins.OpenFoosball.controller;

import com.silentpenguins.OpenFoosball.dao.MyUserDao;
import com.silentpenguins.OpenFoosball.model.MyUser;
import com.silentpenguins.OpenFoosball.pojo.RegisterRQ;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public class RegisterController {

    @Autowired
    MyUserDao myUserDao;

    @PostMapping("/register")
    public Response createMatch(Map<String, Object> model, @RequestBody RegisterRQ registerRQ) {
        Response response = new Response();
        response.setStatus(200);
        response.addDateHeader("kutas", 300);
        System.out.printf(registerRQ.getLogin());
        System.out.printf(registerRQ.getPassword());

        //myUserDao.save(new MyUser("admin", "admin",true, "ADMIN"));
        return response;
    }
}
