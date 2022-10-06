package nl.hu.bep2.casino.blackJackGame.domain.factories;

import nl.hu.bep2.casino.blackJackGame.domain.State;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;

public class GameView {
    public State State;
    public Hand playerHand;
    public Hand dealerHand;

    public GameView(State State, Hand playerHand, Hand dealerHand) {
        this.State = State;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
    }
}
