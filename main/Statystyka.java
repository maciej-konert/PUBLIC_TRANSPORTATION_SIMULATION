package main;

import zadanie.LiniaTramwajowa;
import zadanie.Pasazer;
import zadanie.Tramwaj;

public class Statystyka {
    private static final int[] przejazdyNaDzien = new int[Symulacja.getDniSymulacji()];
    private static final int[] czasOczekiwaniaNaDzien = new int[Symulacja.getDniSymulacji()];
    private static final int[] ileOczekiwanNaDzien = new int[Symulacja.getDniSymulacji()];

    public static void ustawLiczbePrzejazdowWDniu() {
        int liczba = 0;

        for (Pasazer p : Symulacja.getPasazerowie())
            liczba += p.getLiczbaPrzejazdow();

        przejazdyNaDzien[Symulacja.getAktualnyDzien()] = liczba;
    }

    private static int obliczLacznePrzejazdy() {
        int ileLacznie = 0;

        for (int x : przejazdyNaDzien)
            ileLacznie += x;

        return ileLacznie;
    }

    public static void ustawOczekiwanieWDniu() {
        int ileCzekali = 0;

        // Pasazer zostal w tramwaju na koncu symulacji.
        for (LiniaTramwajowa l : Symulacja.getLinieTramwajowe())
            for (Tramwaj t : l.getTramwaje())
                for (int i = 0; i < t.getIndeksWstawieniaPasazera(); i++)
                    if (t.getListaPasazerow()[i] != null)
                        t.getListaPasazerow()[i].setMinutaOstatniegoPrzybycia(24*60);

        for (Pasazer p : Symulacja.getPasazerowie())
            if (p.getCzyPrzyszedlNaPrzystanek() && p.getMinutaOstatniegoPrzybycia() != 24 * 60) {
                ileCzekali += p.getLacznyCzasOczekiwania() + 24 * 60 -
                        Math.max(p.getMinutaPrzybyciaNaPrzystanek(),
                                p.getMinutaOstatniegoPrzybycia());
                ileOczekiwanNaDzien[Symulacja.getAktualnyDzien()] +=
                        p.getLiczbaPrzejazdow() + 1;
            } else if (p.getCzyPrzyszedlNaPrzystanek() && p.getMinutaOstatniegoPrzybycia() == 24 * 60) {
                ileCzekali += p.getLacznyCzasOczekiwania();
                ileOczekiwanNaDzien[Symulacja.getAktualnyDzien()] += p.getLiczbaPrzejazdow();
            }
        czasOczekiwaniaNaDzien[Symulacja.getAktualnyDzien()] = ileCzekali;
    }

    private static float obliczSredniCzas() {
        int oczekiwania = 0, czas = 0;

        for (int i = 0; i < Symulacja.getDniSymulacji(); i++) {
            oczekiwania += ileOczekiwanNaDzien[i];
            czas += czasOczekiwaniaNaDzien[i];
        }

        return (float) czas / oczekiwania;
    }

    public static void wypiszSymulacje() {
        System.out.println();
        System.out.println("****PODSUMOWANIE SYMULACJI****");
        System.out.println();

        System.out.println("Łączna liczba przejazdów w całej symulacji to: " +
                obliczLacznePrzejazdy());

        System.out.printf("Średni czas oczekiwania na przystanku to: %.2f minut", obliczSredniCzas());

        System.out.println();
        System.out.println();
        System.out.println("STATYSTYKI DLA POSZCZEGÓLNYCH DNI TO: ");
        System.out.println("DZIEŃ  |  LICZBA PRZEJAZDÓW  |  CZAS NA PRZYSTANKU");

        for (int i = 0; i < Symulacja.getDniSymulacji(); i++)
            System.out.println(i + "      |        "  + przejazdyNaDzien[i]  +
                    "          |        " + czasOczekiwaniaNaDzien[i]);

    }
}
