package zdarzenia;

import zadanie.Przystanek;
import zadanie.Tramwaj;

public class PrzyjazdTramwaju extends Zdarzenie {
    private final Przystanek gdziePrzyjechal;
    private final Tramwaj tramwaj;

    public PrzyjazdTramwaju(int dzien, int minuta, Przystanek gdziePrzyjechal, Tramwaj tramwaj) {
        super(dzien, minuta);
        this.gdziePrzyjechal = gdziePrzyjechal;
        this.tramwaj = tramwaj;
    }

    @Override
    public void przetworzZdarzenie() {
        tramwaj.zwiekszIlePrzejechalPrzyst();
        tramwaj.symulujPrzyjazdTramwaju(dzien, minuta, gdziePrzyjechal);
    }

    @Override
    public String toString() {
        return super.toString() + "Tramwaj linii: " + tramwaj.getLinia().getNumerLinii() +
                " (nr bocz. " + tramwaj.getNumerBoczny() + ") przyjechał na przystanek " +
                gdziePrzyjechal.getNazwa() + ".";
    }
}
