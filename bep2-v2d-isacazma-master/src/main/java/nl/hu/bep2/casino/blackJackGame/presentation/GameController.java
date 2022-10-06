package nl.hu.bep2.casino.blackJackGame.presentation;


import nl.hu.bep2.casino.blackJackGame.application.GameService;
import nl.hu.bep2.casino.blackJackGame.data.GameRepository;
import nl.hu.bep2.casino.blackJackGame.domain.Dealer;
import nl.hu.bep2.casino.blackJackGame.domain.Player;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;
import nl.hu.bep2.casino.blackJackGame.domain.factories.GameView;
import nl.hu.bep2.casino.chips.application.ChipsService;
import nl.hu.bep2.casino.blackJackGame.domain.Game;
import nl.hu.bep2.casino.security.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private ChipsService service;
    private GameService gameService;

    @Autowired
    public  GameController( ChipsService service, GameService gameService) {

        this.service = service;
        this.gameService = gameService;
    }

    @PostMapping("/startGame")
    public Game start(Authentication authentication) {
        UserProfile profile = (UserProfile) authentication.getPrincipal();

     Game  g = this.gameService.StartGame(profile.getUsername(), service);
     return g;

    }


    @PostMapping("/hit")
    public Game hit() {
        return this.gameService.hit();
    }

    private GameView createGameView(Game game) {
        return new GameView(
        game.getState(),game.getPlayer().getHand(),game.getDealer().getHand());
    }
}
