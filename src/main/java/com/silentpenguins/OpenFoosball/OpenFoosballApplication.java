package com.silentpenguins.OpenFoosball;

import com.silentpenguins.OpenFoosball.dao.PlayerDao;
import com.silentpenguins.OpenFoosball.pojo.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenFoosballApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFoosballApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner initData(PlayerDao playerDao){
		return args -> {
			for(int i =0 ; i< 10 ; ++i){
				Player player1 = new Player();

				Player player2 = new Player();
				player2.setId(2);
				player2.setUserName("MPUC");
				player2.setFirstName("Martin");
				player2.setLastName("Putz");

				Player player3 = new Player();
				player3.setId(3);
				player3.setUserName("Pointerrr");
				player3.setFirstName("Piotr");
				player3.setLastName("Komorowski");

				Player player4 = new Player();
				player4.setId(4);
				player4.setUserName("Elo");
				player4.setFirstName("ELOELOELO");
				player4.setLastName("dlkamsdlasmdk");

				playerDao.save(player1);
				playerDao.save(player2);
				playerDao.save(player3);
				playerDao.save(player4);

			}
			playerDao.save(new Player("mati", null, "Mateusz", "Plesinski", 10000, 10000, 10000000));

		};
	}*/
}
