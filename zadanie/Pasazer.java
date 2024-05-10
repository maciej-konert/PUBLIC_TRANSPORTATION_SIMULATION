package zadanie;

import main.Losowanie;
import main.Symulacja;
import zdarzenia.KolejkaZdarzen;
import zdarzenia.PrzybyciePasazera;

public class Pasazer {
    private final Przystanek przystanekWPoblizu;
    private int lacznyCzasOczekiwania = 0;
    private int liczbaPrzejazdow = 0;
    private int minutaOstatniegoPrzybycia = 0;
    private int minutaPrzybyciaNaPrzystanek;
    private boolean czyPrzyszedlNaPrzystanek;
    private final int indeksPasazera;
    private Przystanek gdzieJedzie;

    public Pasazer(Przystanek przystanekWPoblizu, int indeksPasazera) {
        this.przystanekWPoblizu = przystanekWPoblizu;
        this.indeksPasazera = indeksPasazera;
    }

    public void symulujPrzyjscieNaPrzystanek() {
        KolejkaZdarzen.wstawZdarzenie(new PrzybyciePasazera(Symulacja.getAktualnyDzien(),
                Losowanie.kiedyWyjscZDomu(), przystanekWPoblizu, this));
    }

    public int getIndeksPasazera() {
        return indeksPasazera;
    }

    public Przystanek getGdzieJedzie() {
        return gdzieJedzie;
    }

    public int getLacznyCzasOczekiwania() {
        return lacznyCzasOczekiwania;
    }

    public int getLiczbaPrzejazdow() {
        return liczbaPrzejazdow;
    }

    public int getMinutaOstatniegoPrzybycia() {
        return minutaOstatniegoPrzybycia;
    }

    public boolean getCzyPrzyszedlNaPrzystanek() {
        return czyPrzyszedlNaPrzystanek;
    }

    public int getMinutaPrzybyciaNaPrzystanek() {
        return minutaPrzybyciaNaPrzystanek;
    }

    public void setMinutaPrzybyciaNaPrzystanek(int minutaPrzybyciaNaPrzystanek) {
        this.minutaPrzybyciaNaPrzystanek = minutaPrzybyciaNaPrzystanek;
    }

    public void setCzyPrzyszedlNaPrzystanek(boolean czyPrzyszedlNaPrzystanek) {
        this.czyPrzyszedlNaPrzystanek = czyPrzyszedlNaPrzystanek;
    }

    public void setMinutaOstatniegoPrzybycia(int minutaOstatniegoPrzybycia) {
        this.minutaOstatniegoPrzybycia = minutaOstatniegoPrzybycia;
    }

    public void wyzerujDoStatystyk() {
        liczbaPrzejazdow = 0;
        lacznyCzasOczekiwania = 0;
    }

    public void dodajJedenPrzejazd() {
        liczbaPrzejazdow++;
    }

    public void zwiekszCzasOczekiwania(int oIleZwiekszyc) {
        lacznyCzasOczekiwania += oIleZwiekszyc;
    }

    public void setGdzieJedzie(Przystanek gdzieJedzie) {
        this.gdzieJedzie = gdzieJedzie;
    }

    @Override
    public String toString() {
        return "Pasażer nr: " + indeksPasazera;
    }
}
