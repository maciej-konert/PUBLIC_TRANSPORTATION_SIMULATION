package zdarzenia;

import main.Symulacja;
import zadanie.Pasazer;
import zadanie.Przystanek;

public class PrzybyciePasazera extends Zdarzenie {
    private final Przystanek naJakiPrzystanek;
    private final Pasazer ktoPrzyszedl;

    public PrzybyciePasazera(int dzien, int minuta, Przystanek naJakiPrzystanek, Pasazer ktoPrzyszedl) {
        super(dzien, minuta);
        this.naJakiPrzystanek = naJakiPrzystanek;
        this.ktoPrzyszedl = ktoPrzyszedl;
    }


    @Override
    public void przetworzZdarzenie() {
        if (naJakiPrzystanek.czyNiePelny()) {
            naJakiPrzystanek.dodajPasazera(ktoPrzyszedl);
            ktoPrzyszedl.setMinutaOstatniegoPrzybycia(minuta);
            ktoPrzyszedl.setCzyPrzyszedlNaPrzystanek(true);
            ktoPrzyszedl.setMinutaPrzybyciaNaPrzystanek(minuta);
        } else {
            KolejkaZdarzen.wstawZdarzenie(new PowrotDoDomu(Symulacja.getAktualnyDzien(), minuta,
                    naJakiPrzystanek, ktoPrzyszedl));
            ktoPrzyszedl.setCzyPrzyszedlNaPrzystanek(false);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Pasażer " + ktoPrzyszedl.getIndeksPasazera() +
                " przyszedł na przystanek " + naJakiPrzystanek.getNazwa() + ".";
    }
}
