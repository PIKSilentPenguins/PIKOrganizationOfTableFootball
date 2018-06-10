package com.silentpenguins.OpenFoosball.service;

import com.silentpenguins.OpenFoosball.dao.GameDao;
import com.silentpenguins.OpenFoosball.dao.MyUserDao;
import com.silentpenguins.OpenFoosball.dao.UserDao;
import com.silentpenguins.OpenFoosball.dao.ScoringDao;
import com.silentpenguins.OpenFoosball.model.Game;
import com.silentpenguins.OpenFoosball.model.MyUser;
import com.silentpenguins.OpenFoosball.model.User;
import com.silentpenguins.OpenFoosball.model.Scoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class InitDataBaseService {

    @Autowired
    MyUserDao myUserDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ScoringDao scoringDao;

    @Autowired
    GameDao gameDao;

    void initPerson() {
        for(int i =0 ; i< 10 ; ++i){
            User mdo = new User("mdo"+i, null, "Marcin", "Puc", 0, 10000, 0);
            User ptr = new User("ptr"+i, null, "Piotr", "Komorowski", 50, 100, 150);
            User mati = new User("mati"+i, null, "Mateusz", "Plesinski", 10000, 10000, 10000000);
            User was = new User("wasiollo"+i, null, "Mateusz", "Wasiak", 900, 1000, 2700);

            MyUser myMdo = new MyUser(mdo.getUserName(),mdo.getFirstName(), true, "USER" );
            MyUser myPtr = new MyUser(ptr.getUserName(), ptr.getFirstName(), true, "USER" );
            MyUser myMati = new MyUser(mati.getUserName(),mati.getFirstName(), true, "USER" );
            MyUser myWas = new MyUser(was.getUserName(), was.getFirstName(), true, "USER" );

            myMdo.setUserProfile(mdo);
            mdo.setMyUser(myMdo);

            myUserDao.save(myMdo);

            myMati.setUserProfile(mati);
            mati.setMyUser(myMati);

            myUserDao.save(myMati);

            myPtr.setUserProfile(ptr);
            ptr.setMyUser(myPtr);

            myUserDao.save(myPtr);

            myWas.setUserProfile(was);
            was.setMyUser(myWas);

            myUserDao.save(myWas);

        }
        User user = new User("admin", null, "Mateusz", "Plesinski", 10000, 10000, 10000000);
        MyUser myUser = new MyUser("admin","admin", true, "ADMIN" );

        myUser.setUserProfile(user);
        user.setMyUser(myUser);


        myUserDao.save(myUser);


    }

    public void initScoring() {

        Scoring trainingPoints = new Scoring();
        trainingPoints.setName("Training");
        trainingPoints.setPoints(0);

        Scoring regularPoints = new Scoring();
        regularPoints.setName("Regular");
        regularPoints.setPoints(1);

        Scoring tournamentPoints = new Scoring();
        tournamentPoints.setName("Tournament");
        tournamentPoints.setPoints(3);

        scoringDao.save(trainingPoints);
        scoringDao.save(regularPoints);
        scoringDao.save(tournamentPoints);

    }

    public void initGame() {

        for(int i  = 0 ; i < 10 ; ++i) {
            Game game1 = new Game();
            game1.setScoring(scoringDao.findByName("Regular"));

            if( (i%2) == 0){
                User player = userDao.findByUserName("admin");

                if( player != null){
                    game1.getLeftTeam().add(player);
                    player.getLeftGames().add(game1);
                }

                User player2 = userDao.findByUserName("ptr"+i);

                if( player2 != null){
                    game1.getRightTeam().add(player2);
                    player2.getRightGames().add(game1);
                }

                User player3 = userDao.findByUserName("mdo"+i);

                if( player3 != null){
                    game1.getRightTeam().add(player3);
                    player3.getRightGames().add(game1);
                }
                User player4 = userDao.findByUserName("wasiollo"+i);

                if( player4 != null){
                    game1.getLeftTeam().add(player4);
                    player4.getLeftGames().add(game1);
                }
            }
            else {
                User player = userDao.findByUserName("admin");

                if( player != null){
                    game1.getRightTeam().add(player);
                    player.getRightGames().add(game1);
                }

                User player2 = userDao.findByUserName("ptr"+i);

                if( player2 != null){
                    game1.getLeftTeam().add(player2);
                    player2.getLeftGames().add(game1);
                }

                User player3 = userDao.findByUserName("mdo"+i);

                if( player3 != null){
                    game1.getLeftTeam().add(player3);
                    player3.getLeftGames().add(game1);
                }
                User player4 = userDao.findByUserName("wasiollo"+i);

                if( player4 != null){
                    game1.getRightTeam().add(player4);
                    player4.getRightGames().add(game1);
                }
            }


            if( (i % 2) == 0){
                game1.setConfirmed(true);
            }
            else
                game1.setConfirmed(false);

            if( (i % 3) == 0){
                game1.setRightScore(0+i);
                game1.setLeftScore(10+i);
            }
            else if ((i % 3) == 1){
                game1.setRightScore(7+i);
                game1.setLeftScore(2+i);
            }
            else {
                game1.setRightScore(6+i);
                game1.setLeftScore(8+i);
            }

            gameDao.save(game1);
        }
    }



    public void initDataBase() {
        initPerson();
        initScoring();
        initGame();
    }

}
