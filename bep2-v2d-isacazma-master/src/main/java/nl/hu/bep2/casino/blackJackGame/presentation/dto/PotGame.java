package nl.hu.bep2.casino.blackJackGame.presentation.dto;

import javax.validation.constraints.Positive;

public class PotGame {
    @Positive
    public Long betAmount;
}
