package nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck;

import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Card;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hand {


    @OneToMany(cascade = CascadeType.ALL)
    private final List<Card> cards = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;



    public List<Card> getCards() {
        return cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hand() {}

        public void addCard(Card card) {
            this.cards.add(card);
        }

    }
