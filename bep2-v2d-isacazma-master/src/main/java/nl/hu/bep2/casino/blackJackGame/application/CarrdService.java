//package nl.hu.bep2.casino.blackJackGame.application;
//
//import nl.hu.bep2.casino.blackJackGame.data.CardRepository;
//import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.Card;
//import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.TypenKaart;
//import nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck.WaardeKaart;
//import nl.hu.bep2.casino.chips.domain.Chips;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Transactional
//@Service
//public class CarrdService {
//    private final CardRepository cardRepository;
//
//    public CarrdService(CardRepository cardRepository) {
//        this.cardRepository = cardRepository;
//    }
//    public Card saveJet(TypenKaart typenKaart, WaardeKaart waardeKaart){
//        Card card = new Card( typenKaart,waardeKaart);
////        this.cardRepository.save(card);
//        return card;
//    }
//
//    public  Card findChipsByUsername(TypenKaart typenKaart, WaardeKaart waardeKaart) {
//        String naamKaart = "de naam = "+typenKaart +""+waardeKaart;
////        Card test = new Card(typenKaart,  waardeKaart);
//
//
//        Card Card = null;
//        return this.cardRepository
//                .findByNaamKaart(naamKaart)
//                .orElse(this.saveJet(typenKaart ,waardeKaart));
//    }
//
//
//}
