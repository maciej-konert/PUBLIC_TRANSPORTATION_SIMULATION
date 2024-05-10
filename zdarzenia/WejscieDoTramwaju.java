package zdarzenia;

import zadanie.Pasazer;
import zadanie.Tramwaj;

public class WejscieDoTramwaju extends Zdarzenie {
    private final Pasazer ktoWszedl;
    private final Tramwaj doJakiegoTramwaju;

    public WejscieDoTramwaju(int dzien, int minuta, Pasazer ktoWszedl,
                             Tramwaj doJakiegoTramwaju) {
        super(dzien, minuta);
        this.ktoWszedl = ktoWszedl;
        this.doJakiegoTramwaju = doJakiegoTramwaju;
    }

    @Override
    public void przetworzZdarzenie() {
        ktoWszedl.dodajJedenPrzejazd();
        ktoWszedl.zwiekszCzasOczekiwania(minuta -
                ktoWszedl.getMinutaOstatniegoPrzybycia());
    }

    @Override
    public String toString() {
        return super.toString() + "Pasażer " + ktoWszedl.getIndeksPasazera() + " wsiadł do tramwaju linii " +
                doJakiegoTramwaju.getLinia().getNumerLinii() + " (nr boczny " + doJakiegoTramwaju.getNumerBoczny() +
                ") z zamiarem dojechania do przystanku " + ktoWszedl.getGdzieJedzie().getNazwa() + ".";
    }
}
