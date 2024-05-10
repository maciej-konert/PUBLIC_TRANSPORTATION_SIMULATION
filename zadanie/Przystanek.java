package zadanie;

import main.Symulacja;

import java.util.Arrays;

public class Przystanek {
    private final String nazwa;
    private int indeksWstawPasazera = 0;
    private final Pasazer[] listaCzekajacych = new Pasazer[Symulacja.getPojemnoscPrzystanku()];

    public Przystanek(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    // POBIERANIE I DODAWANIE PASAZEROW Z RZYSTANKOW.

    public boolean czyNiePelny() {
        return indeksWstawPasazera != Symulacja.getPojemnoscPrzystanku();
    }

    public int ileWolnychMiejsc() {
        return Symulacja.getPojemnoscPrzystanku() - indeksWstawPasazera;
    }

    private void przesunListePasazerow() {
        int k = 0;

        for (int i = 0; i < Symulacja.getPojemnoscPrzystanku(); i++) {
            if (listaCzekajacych[i] == null)
                 k++;
            else
                listaCzekajacych[i - k] = listaCzekajacych[i];
        }
    }

    public Pasazer[] pobierzPasazerow(int iluMax) {
            int iluPobrac = Math.min(iluMax, indeksWstawPasazera);
            Pasazer[] pobraniPasazerowie = Arrays.copyOfRange(listaCzekajacych,
                    0, iluPobrac);

            for (int i = 0; i < iluPobrac; i++) {
                listaCzekajacych[i] = null;
            }

            przesunListePasazerow();

            indeksWstawPasazera -= iluPobrac;

            return pobraniPasazerowie;
    }

    public void dodajPasazera(Pasazer pasazer) {
        assert indeksWstawPasazera != Symulacja.getPojemnoscPrzystanku() : "Przystanek jest pełny.";

        listaCzekajacych[indeksWstawPasazera] = pasazer;
        indeksWstawPasazera++;
    }

    @Override
    public String toString() {
        return "Przystanek: " + nazwa;
    }
}
