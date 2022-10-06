package nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hand implements Serializable {


    @OneToMany(cascade = CascadeType.ALL)
    private final List<Card> cards = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;



    public int total() {
        int sum = 0;
        for(Card c : cards) {
            c.getWaardeKaart();
        }
        while (sum > 21 && cards.contains(WaardeKaart.Aas)) {
            sum -= 10;
        }

        return sum;
    }

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
