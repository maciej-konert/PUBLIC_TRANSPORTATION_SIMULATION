package zdarzenia;

import java.util.Arrays;

public class KolejkaZdarzen {
    private static final int poczatkowyRozmiar = 20;
    private static Zdarzenie[] kolejka = new Zdarzenie[poczatkowyRozmiar];
    private static int indeksKonca = 0;
    private static int indeksPobrania = 0;

    private static void przesunDoPrawej(int odIndeks) {
        for (int i = indeksKonca - 1; i >= odIndeks; i--) {
            kolejka[i + 1] = kolejka[i];
        }
    }

    private static int binSearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= target)
                start = mid + 1;
            else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void wstawZdarzenie(Zdarzenie zdarzenie) {
        if (indeksKonca == kolejka.length)
            kolejka = Arrays.copyOf(kolejka, kolejka.length * 2);
        if (indeksPobrania != indeksKonca) {
            int[] minutyZdarzen = new int[indeksKonca - indeksPobrania];

            for (int i = 0; i < minutyZdarzen.length; i++)
                minutyZdarzen[i] = kolejka[i + indeksPobrania].getMinuta();

            int key = zdarzenie.getMinuta();

            int indeks = binSearch(minutyZdarzen, key) + indeksPobrania;

            if (indeks != -1) {
                przesunDoPrawej(indeks);
                kolejka[indeks] = zdarzenie;
            } else
                kolejka[indeksKonca] = zdarzenie;
        } else
            kolejka[indeksPobrania] = zdarzenie;

        indeksKonca++;
    }

    public static boolean czyNiePusta() {
        return indeksKonca != indeksPobrania;
    }

    public static Zdarzenie pobierzZdarzenie() {
        assert czyNiePusta() : "Pobranie z pustej kolejki.";

        indeksPobrania++;
        return kolejka[indeksPobrania - 1];
    }

    public static void wyczyscKolejke() {
        kolejka = new Zdarzenie[poczatkowyRozmiar];
        indeksKonca = 0;
        indeksPobrania = 0;
    }
}
