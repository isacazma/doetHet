package nl.hu.bep2.casino;

import nl.hu.bep2.casino.blackJackGame.application.DeckFactory;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

@SpringBootApplication
public class CasinoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CasinoApplication.class, args);




    }
}
