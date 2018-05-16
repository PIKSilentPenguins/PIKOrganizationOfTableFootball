package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.AwardedPointsDao;
import com.silentpenguins.OpenFoosball.dao.MatchDao;
import com.silentpenguins.OpenFoosball.dao.PlayerDao;
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
