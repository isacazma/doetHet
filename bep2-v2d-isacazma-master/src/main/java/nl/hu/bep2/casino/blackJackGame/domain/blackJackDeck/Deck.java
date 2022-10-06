package nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck;

import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Card;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Deck implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Card>cards = new ArrayList<Card>();

    private int teller = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Card getEenCard(){
    teller ++;
    return cards.get(teller);
}


    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getTeller() {
        return teller;
    }

    public void setTeller(int teller) {
        this.teller = teller;
    }

    public void addCard(Card kaart){
        cards.add(kaart);
    }

    public List<Card> getCards() {
        return cards;
    }



}
