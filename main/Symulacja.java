package main;

import zadanie.*;
import zdarzenia.KolejkaZdarzen;
import zdarzenia.Zdarzenie;

public class Symulacja {
    private static Pasazer[] pasazerowie;
    private static LiniaTramwajowa[] linieTramwajowe;
    private static Przystanek[] przystanki;
    private static int pojemnoscTramwaju;
    private static int pojemnoscPrzystanku;
    private static final int godzinaWyjazduTramwajow = 6;
    private static final int godzinaPowrotuTramwajow = 23;
    private static int dniSymulacji;
    private static int aktualnyDzien = 0;

    public static int getPojemnoscTramwaju() {
        return pojemnoscTramwaju;
    }

    public static int getGodzinaWyjazduTramwajow() {
        return godzinaWyjazduTramwajow;
    }

    public static int getGodzinaPowrotuTramwajow() {
        return godzinaPowrotuTramwajow;
    }

    public static int getDniSymulacji() {
        return dniSymulacji;
    }

    public static int getAktualnyDzien() {
        return aktualnyDzien;
    }

    public static Przystanek[] getPrzystanki() {
        return przystanki;
    }

    public static Pasazer[] getPasazerowie() {
        return pasazerowie;
    }

    public static int getPojemnoscPrzystanku() {
        return pojemnoscPrzystanku;
    }

    public static LiniaTramwajowa[] getLinieTramwajowe() {
        return linieTramwajowe;
    }

    public static void setSymulacjaInts(int dniSymulacji, int pojemnoscTramwaju) {
        Symulacja.dniSymulacji = dniSymulacji;
        Symulacja.pojemnoscTramwaju = pojemnoscTramwaju;
    }

    public static void setPojemnoscPrzystanku(int pojemnoscPrzystanku) {
        Symulacja.pojemnoscPrzystanku = pojemnoscPrzystanku;
    }

    public static void setPasazerowie(Pasazer[] pasazerowie) {
        Symulacja.pasazerowie = pasazerowie;
    }

    public static void setLinie(LiniaTramwajowa[] linie) {
        Symulacja.linieTramwajowe = linie;
    }

    public static void setPrzystanki(Przystanek[] przystanki) {
        Symulacja.przystanki = przystanki;
    }

    // GLOWNA SYMULACJA.

    private static void symulujTramwaje() {
        for (LiniaTramwajowa l : linieTramwajowe)
            l.symulujTramwaje();
    }

    private static void symulujPasazerow() {
        for (Pasazer p : pasazerowie)
            p.symulujPrzyjscieNaPrzystanek();
    }

    private static void skorzystajZKolejki() {

        while (KolejkaZdarzen.czyNiePusta()) {
            Zdarzenie z = KolejkaZdarzen.pobierzZdarzenie();

            z.przetworzZdarzenie();
            System.out.println(z);
        }

        KolejkaZdarzen.wyczyscKolejke();
    }

    private static void ustawOdNowa() {
        for (Przystanek p : przystanki)
            p.pobierzPasazerow(pojemnoscPrzystanku);
        for (LiniaTramwajowa l : linieTramwajowe)
            for (Tramwaj t : l.getTramwaje())
                t.ustawOdNowa();
        for (Pasazer p : pasazerowie)
            p.wyzerujDoStatystyk();
    }

    public static void glownaSymulacja() {
        Skaner.wczytajDane();

        for (int i = 0; i < dniSymulacji; i++) {

            symulujTramwaje();
            symulujPasazerow();

            skorzystajZKolejki();

            Statystyka.ustawLiczbePrzejazdowWDniu();
            Statystyka.ustawOczekiwanieWDniu();

            ustawOdNowa();

            aktualnyDzien++;
        }

        Statystyka.wypiszSymulacje();
    }

}
