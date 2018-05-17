package com.silentpenguins.OpenFoosball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    PlayerListPageService playerListPageService;

    @Autowired
    MatchHistoryService matchHistoryService;

    @Autowired
    ScoringPageService scoringPageService;

    public void initDataBase() {
        playerListPageService.initData();
        matchHistoryService.initData();
        scoringPageService.initScoring();
    }
}
