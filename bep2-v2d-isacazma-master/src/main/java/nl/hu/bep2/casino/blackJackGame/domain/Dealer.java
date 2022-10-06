package nl.hu.bep2.casino.blackJackGame.domain;

import nl.hu.bep2.casino.blackJackGame.application.DeckFactory;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Card;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Dealer implements Serializable {
    @OneToOne(cascade = {CascadeType.ALL})
    private Hand hand;

    @OneToOne(cascade = {CascadeType.ALL})
    private Deck deck;

    @Id
    @GeneratedValue
    private Long id;
//    public Dealer(Hand hand) {
//        this.hand = hand;
//        DeckFactory h = new DeckFactory();
//        deck = new Deck();
//
//
//         deck = h.get

    public Dealer(Deck deck, Hand hand) {
        this.deck = deck;
        this.hand = hand;
    }

    public Dealer( Hand hand) {

        this.hand = hand;
    }
    public Dealer() {}

public Hand getCardFromDeck(){
        return hand;
}
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
        DeckFactory h = new DeckFactory();

        return h.getRandomDeck();
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    public Deck setNewDeck(){
        DeckFactory h = new DeckFactory();

        return h.getRandomDeck();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "hand=" + hand +
                ", deck=" + deck +
                ", id=" + id +
                '}';
    }
}
