package main;

public class Symulacja {
    private static int pojemnoscTramwaju;
    private static int pojemnoscPrzystanku;
    private static final int godzinaWyjazduTramwajow = 6;
    private static final int godzinaPrzyjazduTramwajow = 23;
    private static int dniSymulacji;
    private static int aktualnyDzien = 0;

    public static int getPojemnoscTramwaju() {
        return pojemnoscTramwaju;
    }

    public static int getGodzinaWyjazduTramwajow() {
        return godzinaWyjazduTramwajow;
    }

    public static int getGodzinaPrzyjazduTramwajow() {
        return godzinaPrzyjazduTramwajow;
    }

    public static int getDniSymulacji() {
        return dniSymulacji;
    }

    public static int getAktualnyDzien() {
        return aktualnyDzien;
    }

    public static void setPojemnoscTramwaju(int pojemnoscTramwaju) {
        Symulacja.pojemnoscTramwaju = pojemnoscTramwaju;
    }

    public static void setDniSymulacji(int dniSymulacji) {
        Symulacja.dniSymulacji = dniSymulacji;
    }

    public static void setPojemnoscPrzystanku(int pojemnoscPrzystanku) {
        Symulacja.pojemnoscPrzystanku = pojemnoscPrzystanku;
    }

    public void incrementDzien() {
        Symulacja.aktualnyDzien++;
    }

}
