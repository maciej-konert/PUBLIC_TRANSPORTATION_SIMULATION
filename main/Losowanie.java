package main;

import zadanie.Linia;
import zadanie.Przystanek;

import java.util.Random;

public class Losowanie {
    public static final int godzinaPasazerOD = 6;
    public static final int getGodzinaPasazerDO = 12;

    public static int losuj(int dolna, int gorna) {
        Random r = new Random();
        return r.nextInt(dolna, ++gorna);
    }

    /**
     * @return Minuta wyjscia liczona od polnocy.
     */
    public static int kiedyWyjscZDomu() {
        return losuj(godzinaPasazerOD * 60, getGodzinaPasazerDO * 60);
    }

    public static Przystanek naKtoryPrzystanek(Linia linia, Przystanek skadOdjazd) {
        int licznik = 0;

        while (!linia.getTrasa()[licznik].equals(skadOdjazd)) {
            licznik++;
        }

        if (licznik == linia.getTrasa().length - 1) {
            return linia.getTrasa()[losuj(0, licznik - 1)];
        } else {
            return linia.getTrasa()[losuj(++licznik, linia.getTrasa().length) - 1];
        }
    }

    public static Przystanek wylosujPrzystanek() {
        int len = Symulacja.getPrzystanki().length;
        return Symulacja.getPrzystanki()[losuj(0, len - 1)];
    }
}

