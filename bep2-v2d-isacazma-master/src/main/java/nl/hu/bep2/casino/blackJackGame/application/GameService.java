package nl.hu.bep2.casino.blackJackGame.application;

import nl.hu.bep2.casino.blackJackGame.data.*;
import nl.hu.bep2.casino.blackJackGame.domain.Dealer;
import nl.hu.bep2.casino.blackJackGame.domain.Game;
import nl.hu.bep2.casino.blackJackGame.domain.Player;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;
import nl.hu.bep2.casino.blackJackGame.exception.CardValuesToHighException;
import nl.hu.bep2.casino.blackJackGame.exception.GameAlreadyEndedException;
import nl.hu.bep2.casino.blackJackGame.exception.GameNotStartedException;
import nl.hu.bep2.casino.blackJackGame.exception.NoGameHasBeenFoundException;
import nl.hu.bep2.casino.chips.application.ChipsService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Transactional
@Service
public class GameService {
    private final BlackJackRepository blackJackRepository;
    private String playerName;
    private Game game;
    private Dealer dealer;
    private Player player;
    private ChipsService chipsService;


    public GameService(BlackJackRepository blackJackRepository) {
        this.blackJackRepository = blackJackRepository;

    }


    public Game StartGame(String playerName, ChipsService chipsService) {

        this.chipsService = chipsService;
        this.playerName = playerName;

        DeckFactory h = new DeckFactory();
        Deck deck = h.getRandomDeck();

        Hand dealerHand = new Hand();
        Hand playerHand = new Hand();

        dealerHand.addCard(deck.getEenCard());

        Dealer dealer = new Dealer(deck,dealerHand);




        playerHand.addCard(dealer.getCard());
        playerHand.addCard(dealer.getCard());

        Player player = new Player(playerHand);

        Game game = new Game(player, dealer);

        System.out.println(game.getDealer().getId());

        return this.showBalanceFor(game);

    }
    public Game hit() {
        //player gets a card
        try {
            game.hit();
        } catch (CardValuesToHighException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        } catch (GameAlreadyEndedException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        } catch (GameNotStartedException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
        return this.blackJackRepository.save(game);
    }
    private Game showBalanceFor(Game game) {
        System.out.println(game.getId());
        System.out.println("en dit dan");
        this.game = game;

        Game d = new Game();
        d.setPlayer(game.getPlayer());
        d.setDealer(game.getDealer());
        System.out.println(d );
        System.out.println(d.getDealer());
        System.out.println(d.getDealer().getId() );
        System.out.println(d.getDealer().getHand() );
        System.out.println(d.getDealer().getDeck() );
        System.out.println(d.getDealer().getId() );
       this.blackJackRepository.save(d);
        return new Game(
                game.getPlayer(),
                game.getDealer()

        );
    }

    public Game findById(Long id) {
        return blackJackRepository.findById(id).orElseThrow(() -> new NoGameHasBeenFoundException("No game has been found with id: " + id));
    }
}
