package main;

import zadanie.LiniaTramwajowa;
import zdarzenia.KolejkaZdarzen;
import zdarzenia.Zdarzenie;

public class Main {
    public static void main(String[] args) {
        Skaner.wczytajDane();

        for (LiniaTramwajowa l : Symulacja.getLinieTramwajowe())
            l.symulujTramwaje();

        while (KolejkaZdarzen.czyNiePusta())
            System.out.println(KolejkaZdarzen.pobierzZdarzenie().toString());
    }
}
