package zadanie;

import main.Losowanie;
import main.Symulacja;
import zdarzenia.KolejkaZdarzen;
import zdarzenia.WejscieDoTramwaju;
import zdarzenia.WyjscieZTramwaju;

public class Tramwaj extends Pojazd {
    private int ilePrzejechalPrzystankow = 0;
    private final boolean czyStartowalZPoczatku;

    public Tramwaj(int numerBoczny, Linia linia, boolean czyZPoczatku) {
        super(numerBoczny, linia);
        this.listaPasazerow = new Pasazer[Symulacja.getPojemnoscTramwaju()];
        this.czyStartowalZPoczatku = czyZPoczatku;
    }

    public int getIlePrzejechalPrzystankow() {
        return ilePrzejechalPrzystankow;
    }

    public boolean getCzyStartowalZPoczatku() {
        return czyStartowalZPoczatku;
    }

    public void zwiekszIlePrzejechalPrzyst() {
        ilePrzejechalPrzystankow++;
    }

    public boolean czyToNieOstatniPrzystanek() {
        int dlugosc = linia.getTrasa().length;

        return ilePrzejechalPrzystankow % dlugosc != 0;
    }

    public void ustawOdNowa() {
        for (int i = 0; i < indeksWstawieniaPasazera; i++)
            listaPasazerow[i] = null;

        indeksWstawieniaPasazera = 0;
        ilePrzejechalPrzystankow = 0;
    }

    private void ustawPasazerow(int dzien, int minuta,
                                Pasazer[] pasazerowie, Przystanek przystanek) {
        for (Pasazer p : pasazerowie)
            p.setGdzieJedzie(Losowanie.naKtoryPrzystanek(this , przystanek));

        for (int i = 0; i < pasazerowie.length; i++) {
            listaPasazerow[i + indeksWstawieniaPasazera] = pasazerowie[i];
            KolejkaZdarzen.wstawZdarzenie(new WejscieDoTramwaju(dzien, minuta, pasazerowie[i], this));
        }

        indeksWstawieniaPasazera += pasazerowie.length;
    }

    private void przesunListePasazerow() {
        int k = 0;

        for (int i = 0; i < Symulacja.getPojemnoscTramwaju(); i++) {
            if (listaPasazerow[i] == null) k++;
            else {
                listaPasazerow[i - k] = listaPasazerow[i];
            }
        }
    }

    public void sprobojWypuscicPasazerow(int dzien, int minuta, Przystanek przystanek) {
        int i = 0, ileWypuszczono = 0, wolneMiejsca = przystanek.ileWolnychMiejsc();

        while (i < indeksWstawieniaPasazera && ileWypuszczono < wolneMiejsca) {
            if (listaPasazerow[i].getGdzieJedzie().equals(przystanek)) {
                KolejkaZdarzen.wstawZdarzenie(new WyjscieZTramwaju(dzien, minuta,
                        listaPasazerow[i], this));

                przystanek.dodajPasazera(listaPasazerow[i]);

                listaPasazerow[i] = null;

                ileWypuszczono++;
            }

            i++;
        }

        indeksWstawieniaPasazera -= ileWypuszczono;
        przesunListePasazerow();
    }

    public void sprobojWpuscicPasazerow(int dzien, int minuta, Przystanek przystanek) {
        int miejscaWPojezdzie = wolneMiejscaWPojezdzie();
        Pasazer[] nowiPasazerowie = przystanek.pobierzPasazerow(miejscaWPojezdzie);

        ustawPasazerow(dzien, minuta, nowiPasazerowie, przystanek);
    }

    public void symulujPrzyjazdTramwaju(int dzien, int minuta, Przystanek gdziePrzyjechal) {
        if (czyToNieOstatniPrzystanek()) {
            sprobojWypuscicPasazerow(dzien, minuta, gdziePrzyjechal);
            sprobojWpuscicPasazerow(dzien, minuta, gdziePrzyjechal);
        } else
            sprobojWypuscicPasazerow(dzien, minuta, gdziePrzyjechal);
    }

    @Override
    public String toString() {
        return "Tramwaj nr: " + numerBoczny +
                " linii nr: " + linia.getNumerLinii();
    }
}
