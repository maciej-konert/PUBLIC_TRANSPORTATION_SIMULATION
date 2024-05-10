package zdarzenia;

import zadanie.Pasazer;
import zadanie.Tramwaj;

public class WyjscieZTramwaju extends Zdarzenie {
    private final Pasazer ktoWyszedl;
    private final Tramwaj zJakiegoTramwaju;

    public WyjscieZTramwaju(int dzien, int minuta, Pasazer ktoWyszedl, Tramwaj zJakiegoTramwaju) {
        super(dzien, minuta);
        this.ktoWyszedl = ktoWyszedl;
        this.zJakiegoTramwaju = zJakiegoTramwaju;
    }

    @Override
    public void przetworzZdarzenie() {
        ktoWyszedl.setMinutaOstatniegoPrzybycia(minuta);
    }

    @Override
    public String toString() {
        return super.toString() + "Pasażer " + ktoWyszedl.getIndeksPasazera() + " wyszedł z tramwaju linii " +
                zJakiegoTramwaju.getLinia().getNumerLinii() + " (nr boczny " +
                zJakiegoTramwaju.getNumerBoczny() + ").";
    }
}
