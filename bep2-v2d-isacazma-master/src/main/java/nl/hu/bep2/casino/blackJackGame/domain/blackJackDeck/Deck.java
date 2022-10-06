package nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck;

import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Card;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Deck implements Serializable {

    private List<Card>cards = new ArrayList<Card>();

    private int teller = 0;



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
