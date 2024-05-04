package zadanie;

import main.Symulacja;
import zdarzenia.KolejkaZdarzen;
import zdarzenia.PrzyjazdTramwaju;
import zdarzenia.Zdarzenie;

import java.util.Arrays;
import java.util.Objects;

public class LiniaTramwajowa extends Linia {

    private Tramwaj[] tramwaje;

    public LiniaTramwajowa(Przystanek[] trasa, int[] trasaCzasDojazdu, int nrLinii) {
        super(trasa, trasaCzasDojazdu, nrLinii);
    }

    public Tramwaj[] getTramwaje() {
        return tramwaje;
    }

    public void setTramwaje(Tramwaj[] tramwaje) {
        this.tramwaje = tramwaje;
    }

    // DO SYMULACJI TRANWAJOW.

    /**
     * Konwencja - wynik[i] oznacza, ze do przystanku i dojedziemy w wynik[i] minut od poczatku petli.
     */
    private int[] prefiksCzas(int[] tabCzasM) {
        int prefiks = 0;
        int[] prefiksTab = new int[tabCzasM.length];

        for (int i = 0; i < tabCzasM.length; i++) {
            prefiksTab[i] = prefiks;
            prefiks += tabCzasM[i];
        }

        return prefiksTab;
    }

    private int[] sufiksCzas(int[] tabCzasM) {
        int sufiks = 0;
        int[] sufiksTab = new int[tabCzasM.length];

        for (int i = tabCzasM.length - 1; i >= 0 ; i--) {
            sufiksTab[i] = sufiks;
            if (i != 0)
                sufiks += tabCzasM[i - 1];
        }

        return sufiksTab;
    }

    private void symulujZDowolnejStrony(Tramwaj[] doWypuszczenia, int minutyPoczatku,
                                     Przystanek[] trasaM, int[] trasaCzasM) {
        int[] prefiks = prefiksCzas(trasaCzasM), sufiks = sufiksCzas(trasaCzasM);
        int licznik = 0, czasNaPetli = trasaCzasM[trasaCzasM.length - 1],
                coIleWypuszczac =  2 * (prefiks[prefiks.length - 1] + czasNaPetli) / tramwaje.length;

        for (Tramwaj tram : doWypuszczenia) {
            if (licznik + minutyPoczatku <= Symulacja.getGodzinaPowrotuTramwajow() * 60) {
                for (int i = 0; i < trasaM.length; i++)
                    KolejkaZdarzen.wstawZdarzenie(new PrzyjazdTramwaju(Symulacja.getAktualnyDzien(),
                            minutyPoczatku + licznik + prefiks[i], trasaM[i], tram));

                for (int j = trasaM.length - 1; j > 0; j--)
                    KolejkaZdarzen.wstawZdarzenie(new PrzyjazdTramwaju(Symulacja.getAktualnyDzien(),
                            czasNaPetli + prefiks[prefiks.length - 1] + minutyPoczatku +
                                    sufiks[j] + licznik, trasaM[j], tram));

            }
            licznik += coIleWypuszczac;
        }
    }

    private void odwrocTablice(Object[] tab) {
        for(int i = 0; i < tab.length / 2; i++) {
            Object temp = tab[i];
            tab[i] = tab[tab.length - i - 1];
            tab[tab.length - i - 1] = temp;
        }
    }

    private void odwrocTabliceInt(int[] tab) {
        for(int i = 0; i < tab.length / 2; i++) {
            int temp = tab[i];
            tab[i] = tab[tab.length - i - 1];
            tab[tab.length - i - 1] = temp;
        }
    }

    private void przygotujKoniec(Przystanek[] trasaM, int[] trasaCzasM) {
        odwrocTablice(trasaM);

        int ostatni = trasaCzasM[trasaCzasM.length - 1];

        int[] trasaC = Arrays.copyOf(trasaCzasM, trasaCzasM.length - 1);
        odwrocTabliceInt(trasaC);

        int[] trasaC2 = Arrays.copyOf(trasaC, trasaC.length + 1);
        trasaC2[trasaC2.length - 1] = ostatni;

        System.arraycopy(trasaC2, 0, trasaCzasM, 0, trasaC2.length);
    }

    /**
     * Symuluje tramwaje w danym dniu.
     */
    public void symulujTramwaje() {
        Tramwaj[] tramwajePocz, tramwajeKon;
        int dlugosc = tramwaje.length;

        tramwajePocz = Arrays.copyOfRange(tramwaje,0, dlugosc / 2);
        tramwajeKon = Arrays.copyOfRange(tramwaje, dlugosc / 2, dlugosc);

        Przystanek[] trasaM = Arrays.copyOf(this.trasa, this.trasa.length);
        int[] czasM = Arrays.copyOf(this.trasaCzasDojazdu, this.trasaCzasDojazdu.length);

        przygotujKoniec(trasaM, czasM);

        symulujZDowolnejStrony(tramwajePocz, Symulacja.getGodzinaWyjazduTramwajow() * 60,
                trasa, trasaCzasDojazdu);
        symulujZDowolnejStrony(tramwajeKon, Symulacja.getGodzinaWyjazduTramwajow() * 60,
                trasaM, czasM);
    }
}
