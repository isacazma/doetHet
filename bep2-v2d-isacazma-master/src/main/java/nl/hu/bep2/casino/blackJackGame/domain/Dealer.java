package nl.hu.bep2.casino.blackJackGame.domain;

import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Card;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;

import javax.persistence.*;

@Entity
public class Dealer {
    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "hand")
    private Hand hand;

    @Lob
//    @JoinColumn(name = "deck")
    private Deck deck;

    @Id
    @GeneratedValue
    private Long id;


    public Dealer(Deck deck, Hand hand) {
        this.deck = deck;
        this.hand = hand;
    }

    public Dealer( Hand hand) {

        this.hand = hand;
    }
    public Dealer() {}

    public Hand getHand() {
        return null;
    }

    public Card getCard() {
        return deck.getEenCard();
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
