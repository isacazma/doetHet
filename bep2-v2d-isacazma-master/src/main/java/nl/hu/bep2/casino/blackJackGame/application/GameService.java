package nl.hu.bep2.casino.blackJackGame.application;

import nl.hu.bep2.casino.blackJackGame.data.*;
import nl.hu.bep2.casino.blackJackGame.domain.Dealer;
import nl.hu.bep2.casino.blackJackGame.domain.Game;
import nl.hu.bep2.casino.blackJackGame.domain.Player;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;
import nl.hu.bep2.casino.chips.application.ChipsService;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class GameService {
    private final BlackJackRepository blackJackRepository;
//    private final DealerRepossitory dealerRepossitory;
////    private final DeckRepossitory deckRepossitory;
//    private final PlayerRepository playerRepository;
//    private final HandRepository handRepository;
//    private final CardRepository cardRepository;
//    private  CarrdService carrdService;
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

        System.out.println(game.getDealer().getDeck().getCards());
        return this.showBalanceFor(game);
    }
    private Game showBalanceFor(Game game) {
        return new Game(
                game.getPlayer(),
                game.getDealer()
        );
    }
}
