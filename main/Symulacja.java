package main;

import zadanie.Linia;
import zadanie.LiniaTramwajowa;
import zadanie.Pasazer;
import zadanie.Przystanek;

import java.util.Scanner;

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

    public static void incrementDzien() {
        Symulacja.aktualnyDzien++;
    }

    public static void setSymulacjaInts(int dniSymulacji, int pojemnoscPrzystanku, int pojemnoscTramwaju) {
        Symulacja.dniSymulacji = dniSymulacji;
        Symulacja.pojemnoscPrzystanku = pojemnoscPrzystanku;
        Symulacja.pojemnoscTramwaju = pojemnoscTramwaju;
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

}
