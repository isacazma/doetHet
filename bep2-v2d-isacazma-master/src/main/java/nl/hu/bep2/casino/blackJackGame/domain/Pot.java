package nl.hu.bep2.casino.blackJackGame.domain;

public class Pot {
    private Long amount;

    public Pot(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Pot{" +
                "amount=" + amount +
                '}';
    }
}
