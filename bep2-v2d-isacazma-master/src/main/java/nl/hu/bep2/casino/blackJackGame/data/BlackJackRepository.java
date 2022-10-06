package nl.hu.bep2.casino.blackJackGame.data;

import nl.hu.bep2.casino.blackJackGame.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BlackJackRepository extends JpaRepository<Game, Long> {
//    @Override
//    List<Game> findAll();


    Optional<Game> findById(Long id);

//    @Override
//    <S extends Game> S save(S s);

//    @Override
//    void deleteAll();

}
