package nl.hu.bep2.casino.blackJackGame.domain;

import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Hand;

import javax.persistence.*;

@Entity
public class Player implements Person {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "hand_id")
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




    @Override
    public int TotalScoreCardsinHand() {
        return 0;
    }

    @Override
    public Hand getHand() {
        return null;
    }
}
