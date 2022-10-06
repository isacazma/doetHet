package nl.hu.bep2.casino.blackJackGame.domain;

import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;

import javax.persistence.*;

@Entity
public class Player implements Person {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)

    private Hand hand;

    public Player() {
        
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Player(Hand hand) {
        this.hand = hand;
    }





    public int TotalScoreCardsinHand() {
        return 0;
    }


    public Hand getHand() {
        return hand;
    }
    public int getTotaal(){
        return  hand.total();
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", hand=" + hand +
                '}';
    }
}
