package nl.hu.bep2.casino.blackJackGame.domain;


import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;
import nl.hu.bep2.casino.blackJackGame.presentation.dto.PotGame;

import javax.persistence.*;

@Entity
@Table(name ="blackJackTable")

public class Game {
    @OneToOne()
    @JoinColumn(name = "player")
    private Player player;
    @OneToOne()
    @JoinColumn(name = "dealer")
    private Dealer dealer;

    private State state = State.STARTGAME;
    @Id
    @GeneratedValue
    private Long id;


    public Game( Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }


    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Game{" +

                ", player='" + player + '\'' +
                ", dealer='" + dealer + '\'' +

                '}';
    }
}
