package nl.hu.bep2.casino.blackJackGame.domain;

import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;

public interface Person {
    int TotalScoreCardsinHand();
    Hand getHand();
}
