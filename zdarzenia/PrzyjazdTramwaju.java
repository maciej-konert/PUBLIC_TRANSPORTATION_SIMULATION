package zdarzenia;

import zadanie.Przystanek;
import zadanie.Tramwaj;

public class PrzyjazdTramwaju extends Zdarzenie {
    private Przystanek gdziePrzyjechal;
    private Tramwaj tramwaj;

    public PrzyjazdTramwaju(int dzien, int minuta, Przystanek gdziePrzyjechal, Tramwaj tramwaj) {
        super(dzien, minuta);
        this.gdziePrzyjechal = gdziePrzyjechal;
        this.tramwaj = tramwaj;
    }

    @Override
    public String toString() {
        return super.toString() + "Tramwaj linii: " + tramwaj.getLinia().getNumerLinii() +
                " (nr bocz. " + tramwaj.getNumerBoczny() + ") przyjechal na przystanek " +
                gdziePrzyjechal.getNazwa();
    }
}
