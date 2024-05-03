package zdarzenia;

import java.util.Arrays;

public class KolejkaZdarzen {
    private static final int poczatkowyRozmiar = 20;
    private static Zdarzenie[] kolejka = new Zdarzenie[poczatkowyRozmiar];
    private static int indeksWstawiania = 0;
    private static int indeksPobrania = 0;

    public static void wstawZdarzenie(Zdarzenie zdarzenie) {
        if (indeksWstawiania == kolejka.length) {
            kolejka = Arrays.copyOf(kolejka, kolejka.length * 2);
        }
        kolejka[indeksWstawiania] = zdarzenie;
        indeksWstawiania++;
    }

    public static boolean czyPusta() {
        if (indeksWstawiania == 0)
            return true;
        else
            return false;
    }

    public static Zdarzenie pobierzZdarzenie() {
        assert !czyPusta() : "Pobranie z pustej kolejki";
        indeksPobrania++;
        return kolejka[indeksPobrania - 1];
    }

    public static void sortujKolejke() {
        Arrays.sort(kolejka);
    }
}
