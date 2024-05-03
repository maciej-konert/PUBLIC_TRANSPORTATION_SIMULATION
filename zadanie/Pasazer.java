package zadanie;

public class Pasazer {
    private Przystanek przystanekWPoblizu;
    private int lacznyCzasOczekiwania;
    private int liczbaPrzejazdow;
    private int indeksPasazera;

    public Pasazer(Przystanek przystanekWPoblizu, int indeksPasazera) {
        this.przystanekWPoblizu = przystanekWPoblizu;
        this.indeksPasazera = indeksPasazera;
    }
}
