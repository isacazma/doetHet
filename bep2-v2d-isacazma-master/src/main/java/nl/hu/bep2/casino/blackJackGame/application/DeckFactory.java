package nl.hu.bep2.casino.blackJackGame.application;

//import nl.hu.bep2.casino.blackJackGame.application.CarrdService;
//import nl.hu.bep2.casino.blackJackGame.data.CardRepository;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Card;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Deck;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.TypenKaart;
import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.WaardeKaart;

import java.io.Serializable;
import java.util.Collections;

public class DeckFactory implements Serializable {
//    private final CarrdService carrdService;
//
//    public DeckFactory(CarrdService carrdService) {
//        this.carrdService = carrdService;
//    }



    public Deck getDeck(){

        Deck deck = new Deck();

        for (TypenKaart type : TypenKaart.values()){

            for (WaardeKaart waarde : WaardeKaart.values()){
//                String naamKaart = "de naam = "+type +""+waarde;

//                Card cardTest = this.carrdService.findChipsByUsername(type,waarde);

//                this.cardRepository
//                        .findByNaamKaart(naamKaart)
//                        .orElse(new Card(type,waarde));



                Card card = new Card(type,waarde);
                deck.addCard(card);
            }
        }
        return deck;
    }

    public Deck getRandomDeck(){
        Deck deck = getDeck();
        Collections.shuffle(deck.getCards());
        return deck;
    }

}
