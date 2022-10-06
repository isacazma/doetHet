package nl.hu.bep2.casino.blackJackGame.domain.blackJackDeck;

public enum WaardeKaart {
    Twee(2),
    Drie(3),
    Vier(4),
    Vijf(5),
    Zes(6),
    Zeven(7),
    Acht(8),
    Negen(9),
    Tien(10),
    Boer(10),
    Vrouw(10),
    Koning(10),
    Aas(11);


    private int waardeKaart;

    WaardeKaart(int waardeKaart){
        this.waardeKaart = waardeKaart;
    }

    public int getWaardeKaart(){
        return waardeKaart;
    }

}



// infot https://stackoverflow.com/questions/18248977/java-enum-integer-and-string-together-define