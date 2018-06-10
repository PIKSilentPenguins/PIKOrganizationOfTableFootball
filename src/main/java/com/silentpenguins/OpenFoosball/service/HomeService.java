package com.silentpenguins.OpenFoosball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    InitDataBaseService initDataBaseService;

    static boolean isInit = false;

    public void initDataBase() {
        if(!isInit){
            initDataBaseService.initDataBase();
            isInit = true;
        }
    }
}
