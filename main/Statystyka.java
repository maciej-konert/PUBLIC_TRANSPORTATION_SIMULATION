package main;

public class Statystyka {
    private static int liczbaPrzejazdow;
    private static int srednieOczekiwanie;
    private static int[] przejazdyNaDzien = new int[Symulacja.getDniSymulacji()];
    private static int[] czasOczekiwaniaNaDzien = new int[Symulacja.getDniSymulacji()];

    public static void incrementPrzejazdy(int x) {
        Statystyka.liczbaPrzejazdow += x;
    }

    public static void incrementOczekiwanie(int x) {
        Statystyka.srednieOczekiwanie += x;
    }

    public static void setPrzejazdyNaDzien(int ilePrzejazdow) {
        Statystyka.przejazdyNaDzien[Symulacja.getAktualnyDzien()] = ilePrzejazdow;
    }

    public static void setCzasOczekiwaniaNaDzien(int czasOczekiwania) {
        Statystyka.czasOczekiwaniaNaDzien[Symulacja.getAktualnyDzien()] = czasOczekiwania;
    }
}
